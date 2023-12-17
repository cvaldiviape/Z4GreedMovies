package com.catalogs.core.service.product;

import com.catalogs.core.entity.ProductEntity;
import com.catalogs.core.entity.mapper.ProductMapper;
import com.catalogs.core.repository.ProductRepository;
import com.shared.core.service.impl.GenericDeleteService;
import com.shared.dto.external.catalogs.ProductDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("deleteProductImpl")
public class DeleteProductImpl extends GenericDeleteService<ProductEntity, ProductDto, Integer> {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public DeleteProductImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public JpaRepository<ProductEntity, Integer> getJpaRepository() {
        return this.productRepository;
    }

    @Override
    public ProductDto toDto(ProductEntity productEntity) {
        return this.productMapper.toDto(productEntity);
    }

    @Override
    public ProductEntity findEntityById(Integer idProduct) {
        return this.productRepository.findById(idProduct)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.PRODUCT.getValue(), idProduct));
    }

}