package com.catalogs.core.service.categoryproduct;

import com.catalogs.core.entity.CategoryProductEntity;
import com.catalogs.core.entity.mapper.CategoryProductMapper;
import com.catalogs.core.repository.CategoryProductRepository;
import com.shared.core.service.impl.GenericFindAllByListIdsService;
import com.shared.dto.CategoryProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service("findAllCategoryProductByListIdsImpl")
public class FindAllCategoryProductByListIdsImpl extends GenericFindAllByListIdsService<CategoryProductEntity, CategoryProductDto, Integer> {

    private final CategoryProductRepository categoryProductRepository;
    private final CategoryProductMapper categoryProductMapper;

    public FindAllCategoryProductByListIdsImpl(CategoryProductRepository categoryProductRepository, CategoryProductMapper categoryProductMapper) {
        this.categoryProductRepository = categoryProductRepository;
        this.categoryProductMapper = categoryProductMapper;
    }

    @Override
    public JpaRepository<CategoryProductEntity, Integer> getJpaRepository() {
        return this.categoryProductRepository;
    }

    @Override
    public Collection<CategoryProductDto> toListDtos(Collection<CategoryProductEntity> listEntities) {
        return this.categoryProductMapper.toListDtos(listEntities);
    }

}