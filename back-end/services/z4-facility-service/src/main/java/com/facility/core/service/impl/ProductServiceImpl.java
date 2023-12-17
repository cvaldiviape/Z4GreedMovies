package com.facility.core.service.impl;

import com.shared.dto.custom.BasePageDto;
import com.shared.dto.external.catalogs.CategoryProductDto;
import com.shared.dto.external.catalogs.ProductDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.filter.FilterUtil;
import com.shared.utils.response.ResponseDto;
import com.shared.utils.FeignUtil;
import com.shared.utils.PageUtil;
import com.shared.utils.ValidateUtil;
import com.facility.core.client.ProductCategoryFeign;
import com.facility.core.entity.ProductEntity;
import com.facility.core.entity.mapper.ProductMapper;
import com.facility.core.repositories.ProductRepository;
import com.facility.core.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductCategoryFeign productCategoryFeign;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper, ProductCategoryFeign productCategoryFeign) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.productCategoryFeign = productCategoryFeign;
    }

    @Override
    public BasePageDto<ProductDto> findAll(Integer numberPage, Integer sizePage, String sortBy, String sortDir) {
        Pageable pageable = PageUtil.getPageable(numberPage, sizePage, sortBy, sortDir);
        Page<ProductEntity> pageData = this.productRepository.findAll(pageable);
        List<ProductEntity> listEntities = pageData.getContent();

        List<ProductDto> listProducts = this.productMapper.toListDtos(listEntities);

        if (ValidateUtil.hasData(listProducts)){
            setComplementaryData(listProducts);
        }

        return BasePageDto.<ProductDto>builder()
                .listElements(listProducts)
                .numberPage(pageData.getNumber())
                .sizePage(pageData.getSize())
                .totalElements(pageData.getTotalElements())
                .totalPages(pageData.getTotalPages())
                .isLastPage(pageData.isLast())
                .build();
    }

    @Override
    public ProductDto findById(Integer idProduct) {
        ProductEntity entity = this.findProductEntityById(idProduct);
        ProductDto productDto = this.productMapper.toDto(entity);
        Integer idCategory = productDto.getCategory().getIdCategoryProduct();
        CategoryProductDto categoryProduct = findCategoryById(idCategory);
        productDto.setCategory(categoryProduct);
        return productDto;
    }

    @Override
    public ProductDto create(ProductDto productDto) {
        this.validateUniqueFields(productDto);
        ProductEntity productEntity = this.productMapper.toEntity(productDto);
        ProductEntity productCreated = this.productRepository.save(productEntity);
        return this.productMapper.toDto(productCreated);
    }

    @Override
    public ProductDto update(Integer idProduct, ProductDto productDto) {
        ProductEntity productEntity = this.findProductEntityById(idProduct);
        this.validateUniqueFields(idProduct, productDto);
        this.productMapper.updateEntityFromDto(productDto, productEntity);
        ProductEntity productUpdated = this.productRepository.save(productEntity);
        return this.productMapper.toDto(productUpdated);
    }

    @Override
    public ProductDto delete(Integer idProduct) {
        ProductEntity productEntity = this.findProductEntityById(idProduct);
        this.productRepository.delete(productEntity);
        return this.productMapper.toDto(productEntity);
    }

    // ------------------------------------------------------------------------- utils ------------------------------------------------------------------------- //
    public ProductEntity findProductEntityById(Integer idProduct) {
        return this.productRepository.findById(idProduct)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.PRODUCT.getValue(), idProduct));
    }

    private CategoryProductDto findCategoryById(Integer idCategoryProduct) {
        ResponseDto response = productCategoryFeign.findById(idCategoryProduct);
        return FeignUtil.extracstData(response, CategoryProductDto.class, ValueEnum.PRODUCT.getValue());
    }

    private void setComplementaryData(List<ProductDto> listProducts) {
        List<Integer> listIdsCategories = listProducts.stream()
                .map(product -> product.getCategory().getIdCategoryProduct())
                .toList();

        List<CategoryProductDto> listCategoryProducts = findAllCategoriesByListIds(listIdsCategories);

        for (ProductDto product : listProducts) {
            Integer idCategory = product.getCategory().getIdCategoryProduct();
            CategoryProductDto category = FilterUtil.find(listCategoryProducts, idCategory, ValueEnum.CATEGORY.getValue());
            product.setCategory(category);
        }
    }

    private List<CategoryProductDto> findAllCategoriesByListIds(List<Integer> listIdsCategories) {
        ResponseDto response = this.productCategoryFeign.findAllByListIds(listIdsCategories);
        return FeignUtil.extractsDataList(response,CategoryProductDto.class, ValueEnum.LIST_CATEGORY.getValue());
    }

    public void validateUniqueFields(ProductDto productDto) {
        Boolean existsCode = this.productRepository.existsByCode(productDto.getCode());
        Boolean existsDescription = this.productRepository.existsByDescription(productDto.getDescription());
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, productDto.getCode());
        ValidateUtil.validateUnique(existsDescription, ValueEnum.DESCRIPTION, productDto.getDescription());
    }

    public void validateUniqueFields(Integer idProduct, ProductDto productDto) {
        Boolean existsCode = this.productRepository.existsByCodeAndIdProductNot(productDto.getCode(), idProduct);
        Boolean existsDescription = this.productRepository.existsByDescriptionAndIdProductNot(productDto.getDescription(), idProduct);
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, productDto.getCode());
        ValidateUtil.validateUnique(existsDescription, ValueEnum.DESCRIPTION, productDto.getDescription());
    }

}