package com.z4greed.core.service.impl;

import com.shared.dto.custom.BasePageDto;
import com.shared.dto.CategoryProductDto;
import com.shared.dto.ProductDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.filter.FilterUtil;
import com.shared.utils.response.ResponseDto;
import com.shared.utils.FeignUtil;
import com.shared.utils.PageUtil;
import com.shared.utils.ValidateUtil;
import com.z4greed.core.client.ProductCategoryFeign;
import com.z4greed.core.entity.ProductEntity;
import com.z4greed.core.entity.mapper.ProductMapper;
import com.z4greed.core.repositories.ProductRepository;
import com.z4greed.core.service.ProductService;
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
    public ProductDto findById(Integer id) {
        ProductEntity entity = this.findEntityById(id);
        ProductDto productDto = this.productMapper.toDto(entity);
        CategoryProductDto categoryProduct = findCategoryProductById(productDto.getIdCategoryProduct());
        productDto.setCategoryProduct(categoryProduct);
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
    public ProductDto update(Integer id, ProductDto productDto) {
        ProductEntity productEntity = this.findEntityById(id);
        this.validateUniqueFields(id, productDto);
        this.productMapper.updateEntityFromDto(productDto, productEntity);
        ProductEntity productUpdated = this.productRepository.save(productEntity);
        return this.productMapper.toDto(productUpdated);
    }

    @Override
    public ProductDto delete(Integer id) {
        ProductEntity productEntity = this.findEntityById(id);
        this.productRepository.delete(productEntity);
        return this.productMapper.toDto(productEntity);
    }

    // ------------------------------------------------------------------------- utils ------------------------------------------------------------------------- //
    public ProductEntity findEntityById(Integer id) {
        return this.productRepository.findById(id)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.PRODUCT.getValue(), id));
    }

    private CategoryProductDto findCategoryProductById(Integer idCategoryProduct) {
        ResponseDto response = productCategoryFeign.findById(idCategoryProduct);
        return FeignUtil.convertDataToObject(response, CategoryProductDto.class, ValueEnum.PRODUCT.getValue());
    }

    private void setComplementaryData(List<ProductDto> listProducts) {
        List<Integer> listIdsCategories = listProducts.stream()
                .map(ProductDto::getIdCategoryProduct)
                .toList();

        List<CategoryProductDto> listCategoryProducts = findAllCategoriesByListIds(listIdsCategories);

        for (ProductDto product : listProducts) {
            CategoryProductDto category = FilterUtil.find(listCategoryProducts, product.getIdCategoryProduct(), ValueEnum.CATEGORY.getValue());
            product.setCategoryProduct(category);
        }
    }

    private List<CategoryProductDto> findAllCategoriesByListIds(List<Integer> listIdsCategories) {
        ResponseDto response = this.productCategoryFeign.findAllByListIds(listIdsCategories);
        return FeignUtil.convertDataToList(response,CategoryProductDto.class, ValueEnum.LIST_CATEGORY.getValue());
    }

    public void validateUniqueFields(ProductDto productDto) {
        Boolean existsCode = this.productRepository.existsByCode(productDto.getCode());
        Boolean existsDescription = this.productRepository.existsByDescription(productDto.getDescription());
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, productDto.getCode());
        ValidateUtil.validateUnique(existsDescription, ValueEnum.DESCRIPTION, productDto.getDescription());
    }

    public void validateUniqueFields(Integer id, ProductDto productDto) {
        Boolean existsCode = this.productRepository.existsByCodeAndIdProductNot(productDto.getCode(), id);
        Boolean existsDescription = this.productRepository.existsByDescriptionAndIdProductNot(productDto.getDescription(), id);
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, productDto.getCode());
        ValidateUtil.validateUnique(existsDescription, ValueEnum.DESCRIPTION, productDto.getDescription());
    }

}