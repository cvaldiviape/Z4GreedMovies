package com.z4greed.core.service.impl;

import com.shared.dto.custom.BasePageDto;
import com.shared.dto.CategoryProductDto;
import com.shared.dto.ProductDto;
import com.shared.utils.filter.FilterUtil;
import com.shared.utils.response.ResponseDto;
import com.shared.utils.FeignUtil;
import com.shared.utils.PageUtil;
import com.shared.utils.ValidateUtil;
import com.z4greed.core.client.ProductCategoryFeign;
import com.z4greed.core.enums.ProductValueEnum;
import com.z4greed.core.model.entity.ProductEntity;
import com.z4greed.core.model.mapper.ProductMapper;
import com.z4greed.core.repositories.ProductRepository;
import com.z4greed.core.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

        List<ProductDto> listProducts = productMapper.toDtoList(listEntities);

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
        ProductEntity productEntity = this.productMapper.toEntity(productDto);
        ProductEntity productCreated = this.productRepository.save(productEntity);
        return this.productMapper.toDto(productCreated);
    }

    @Override
    public ProductDto update(Integer id, ProductDto productDto) {
        ProductEntity productEntity = this.findEntityById(id);
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
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ProductValueEnum.PRODUCT.getValue(), id));
    }

    private CategoryProductDto findCategoryProductById(Integer idCategoryProduct) {
        ResponseDto response = productCategoryFeign.findById(idCategoryProduct);
        return FeignUtil.convertDataToObject(response, CategoryProductDto.class, ProductValueEnum.PRODUCT.getValue());
    }

    private void setComplementaryData(List<ProductDto> listProducts) {
        List<Integer> listIdsCategories = listProducts.stream()
                .map(ProductDto::getIdCategoryProduct)
                .toList();

        List<CategoryProductDto> listCategoryProducts = findAllCategoriesByListIds(listIdsCategories);

        for (ProductDto product : listProducts) {
            CategoryProductDto category = FilterUtil.find(listCategoryProducts, product.getIdCategoryProduct(), ProductValueEnum.CATEGORY.getValue());
            product.setCategoryProduct(category);
        }
    }

    private List<CategoryProductDto> findAllCategoriesByListIds(List<Integer> listIdsCategories) {
        ResponseDto response = productCategoryFeign.findAllByListIds(listIdsCategories);
        return FeignUtil.convertDataToList(response, CategoryProductDto.class, ProductValueEnum.LIST_CATEGORY.getValue());
    }

//    public void verifyUnique(ProductDto dto) {
//        Boolean existsCode = this.productRepository.existsByCode(dto.getCode());
//        ValidateUtil.evaluate(existsCode, "The code " + dto.getCode() + " already exists.");
//        Boolean existsName = this.productRepository.existsByName(dto.getName());
//        ValidateUtil.evaluate(existsName, "The name " + dto.getName() + " already exists.");
//    }
//
//    public void verifyUnique(Integer id, ProductDto dto) {
//        Boolean existsCode = this.productRepository.existsByCodeAndIdCountryNot(dto.getCode(), id);
//        ValidateUtil.evaluate(existsCode, "The code " + dto.getCode() + " already exists.");
//        Boolean existsName = this.productRepository.existsByNameAndIdCountryNot(dto.getName(), id);
//        ValidateUtil.evaluate(existsName, "The name " + dto.getName() + " already exists.");
//    }

}