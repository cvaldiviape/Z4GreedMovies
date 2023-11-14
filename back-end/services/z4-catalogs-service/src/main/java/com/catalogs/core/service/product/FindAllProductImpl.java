package com.catalogs.core.service.product;

import com.catalogs.core.entity.ProductEntity;
import com.catalogs.core.entity.mapper.ProductMapper;
import com.catalogs.core.repository.ProductRepository;
import com.shared.core.service.impl.GenericFindAllService;
import com.shared.dto.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service("findAllProductImpl")
public class FindAllProductImpl extends GenericFindAllService<ProductEntity, ProductDto, Integer> {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public FindAllProductImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public JpaRepository<ProductEntity, Integer> getJpaRepository() {
        return this.productRepository;
    }

    @Override
    public Collection<ProductDto> toListDtos(Collection<ProductEntity> listEntities) {
        return this.productMapper.toListDtos(listEntities);
    }

}