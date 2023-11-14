package com.catalogs.core.service.product;

import com.catalogs.core.entity.CategoryProductEntity;
import com.catalogs.core.entity.ProductEntity;
import com.catalogs.core.entity.mapper.CategoryProductMapper;
import com.catalogs.core.entity.mapper.ProductMapper;
import com.catalogs.core.repository.CategoryProductRepository;
import com.catalogs.core.repository.ProductRepository;
import com.shared.core.service.UpdateService;
import com.shared.dto.CategoryProductDto;
import com.shared.dto.ProductDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("updateProductImpl")
@Transactional
public class UpdateProductImpl implements UpdateService<ProductDto, Integer> {

    private final ProductRepository productRepository;
    private final CategoryProductRepository categoryProductRepository;
    private final ProductMapper productMapper;
    private final CategoryProductMapper categoryProductMapper;

    public UpdateProductImpl(ProductRepository productRepository, CategoryProductRepository categoryProductRepository, ProductMapper productMapper, CategoryProductMapper categoryProductMapper) {
        this.productRepository = productRepository;
        this.categoryProductRepository = categoryProductRepository;
        this.productMapper = productMapper;
        this.categoryProductMapper = categoryProductMapper;
    }

    @Override
    public ProductDto update(Integer idProduct, ProductDto productDto) {
        ProductEntity productEntity = this.findProductEntityById(idProduct);
        this.validateUniqueFields(idProduct, productDto);
        this.setComplementaryData(productDto);
        productEntity.setCategory(null);
        this.productMapper.updateEntityFromDtoIgnoredId(productDto, productEntity);

        ProductEntity productUpdated = this.productRepository.save(productEntity);
        return this.productMapper.toDto(productUpdated);
    }

    // ------------------------------------------------------------------------- utils ------------------------------------------------------------------------- //
    private ProductEntity findProductEntityById(Integer idProduct) {
        return this.productRepository.findById(idProduct)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.PRODUCT.getValue(), idProduct));
    }

    private void validateUniqueFields(Integer idProduct, ProductDto productDto) {
        Boolean existsCode = this.productRepository.existsByCodeAndIdProductNot(productDto.getCode(), idProduct);
        Boolean existsDescription = this.productRepository.existsByDescriptionAndIdProductNot(productDto.getDescription(), idProduct);
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, productDto.getCode());
        ValidateUtil.validateUnique(existsDescription, ValueEnum.DESCRIPTION, productDto.getDescription());
    }

    private void setComplementaryData(ProductDto productDto) {
        Integer idCategoryProduct = productDto.getCategory().getIdCategoryProduct();
        CategoryProductEntity categoryProductEntity = this.findCategoryProductById(idCategoryProduct);

        CategoryProductDto categoryProductDto = this.categoryProductMapper.toDto(categoryProductEntity);
        productDto.setCategory(categoryProductDto);
    }

    private CategoryProductEntity findCategoryProductById(Integer idCategoryProduct) {
        return this.categoryProductRepository.findById(idCategoryProduct)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.CATEGORY.getValue(), idCategoryProduct));
    }

}