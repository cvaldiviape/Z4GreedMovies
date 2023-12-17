package com.catalogs.core.service.product;

import com.catalogs.core.entity.CategoryProductEntity;
import com.catalogs.core.entity.ProductEntity;
import com.catalogs.core.entity.mapper.CategoryProductMapper;
import com.catalogs.core.entity.mapper.ProductMapper;
import com.catalogs.core.repository.CategoryProductRepository;
import com.catalogs.core.repository.ProductRepository;
import com.shared.core.service.CreateService;
import com.shared.dto.external.catalogs.CategoryProductDto;
import com.shared.dto.external.catalogs.ProductDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("createProductImpl")
@Transactional
public class CreateProductImpl implements CreateService<ProductDto> {

    private final ProductRepository productRepository;
    private final CategoryProductRepository categoryProductRepository;
    private final ProductMapper productMapper;
    private final CategoryProductMapper categoryProductMapper;

    public CreateProductImpl(ProductRepository productRepository, CategoryProductRepository categoryProductRepository, ProductMapper productMapper, CategoryProductMapper categoryProductMapper) {
        this.productRepository = productRepository;
        this.categoryProductRepository = categoryProductRepository;
        this.productMapper = productMapper;
        this.categoryProductMapper = categoryProductMapper;
    }

    @Override
    public ProductDto create(ProductDto productDto) {
        this.validateUniqueFields(productDto);
        this.setComplementaryData(productDto);
        ProductEntity productEntity = this.productMapper.toEntity(productDto);
        ProductEntity productCreated = this.productRepository.save(productEntity);
        return this.productMapper.toDto(productCreated);
    }

    // ------------------------------------------------------------------------- utils ------------------------------------------------------------------------- //
    private void validateUniqueFields(ProductDto productDto) {
        Boolean existsCode = this.productRepository.existsByCode(productDto.getCode());
        Boolean existsDescription = this.productRepository.existsByDescription(productDto.getDescription());
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, productDto.getCode());
        ValidateUtil.validateUnique(existsDescription, ValueEnum.DESCRIPTION, productDto.getDescription());
    }

    private void setComplementaryData(ProductDto productDto) {
        Integer idCategoryProduct = productDto.getCategory().getIdCategoryProduct();
        CategoryProductEntity categoryProductEntity = this.findCategoryProductEntityById(idCategoryProduct);
        CategoryProductDto categoryProductDto = this.categoryProductMapper.toDto(categoryProductEntity);
        productDto.setCategory(categoryProductDto);
    }

    private CategoryProductEntity findCategoryProductEntityById(Integer idCategoryProduct) {
        return this.categoryProductRepository.findById(idCategoryProduct)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.CATEGORY.getValue(), idCategoryProduct));
    }

}