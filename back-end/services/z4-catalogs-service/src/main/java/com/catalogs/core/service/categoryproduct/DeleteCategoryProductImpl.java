package com.catalogs.core.service.categoryproduct;

import com.catalogs.core.entity.CategoryProductEntity;
import com.catalogs.core.entity.mapper.CategoryProductMapper;
import com.catalogs.core.repository.CategoryProductRepository;
import com.shared.core.service.impl.GenericDeleteService;
import com.shared.dto.external.catalogs.CategoryProductDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("deleteCategoryProductImpl")
public class DeleteCategoryProductImpl extends GenericDeleteService<CategoryProductEntity, CategoryProductDto, Integer> {

    private final CategoryProductRepository categoryProductRepository;
    private final CategoryProductMapper categoryProductMapper;

    public DeleteCategoryProductImpl(CategoryProductRepository categoryProductRepository, CategoryProductMapper categoryProductMapper) {
        this.categoryProductRepository = categoryProductRepository;
        this.categoryProductMapper = categoryProductMapper;
    }

    @Override
    public JpaRepository<CategoryProductEntity, Integer> getJpaRepository() {
        return this.categoryProductRepository;
    }

    @Override
    public CategoryProductDto toDto(CategoryProductEntity categoryProductEntity) {
        return this.categoryProductMapper.toDto(categoryProductEntity);
    }

    @Override
    public CategoryProductEntity findEntityById(Integer idCategoryProduct) {
        return this.categoryProductRepository.findById(idCategoryProduct)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.CATEGORY.getValue(), idCategoryProduct));
    }

}