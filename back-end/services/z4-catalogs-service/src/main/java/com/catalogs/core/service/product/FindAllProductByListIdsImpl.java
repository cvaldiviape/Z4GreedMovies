package com.catalogs.core.service.product;

import com.catalogs.core.entity.ProductEntity;
import com.catalogs.core.entity.mapper.ProductMapper;
import com.catalogs.core.repository.ProductRepository;
import com.shared.core.service.impl.GenericFindAllByListIdsService;
import com.shared.dto.external.catalogs.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service("findAllProductByListIdsImpl")
public class FindAllProductByListIdsImpl extends GenericFindAllByListIdsService<ProductEntity, ProductDto, Integer> {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public FindAllProductByListIdsImpl(ProductRepository productRepository, ProductMapper productMapper) {
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