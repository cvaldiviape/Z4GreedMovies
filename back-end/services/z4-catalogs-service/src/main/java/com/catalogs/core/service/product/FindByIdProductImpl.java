package com.catalogs.core.service.product;

import com.catalogs.core.entity.ProductEntity;
import com.catalogs.core.entity.mapper.ProductMapper;
import com.catalogs.core.repository.ProductRepository;
import com.shared.core.service.impl.GenericFindByIdService;
import com.shared.dto.external.catalogs.ProductDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.stereotype.Service;

@Service("findByIdProductImpl")
public class FindByIdProductImpl extends GenericFindByIdService<ProductEntity, ProductDto, Integer> {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public FindByIdProductImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
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