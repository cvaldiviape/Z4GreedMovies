package com.catalogs.core.service.categoryproduct;

import com.catalogs.core.entity.CategoryProductEntity;
import com.catalogs.core.entity.mapper.CategoryProductMapper;
import com.catalogs.core.repository.CategoryProductRepository;
import com.shared.core.service.impl.GenericCreateService;
import com.shared.dto.external.catalogs.CategoryProductDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("createCategoryProductImpl")
public class CreateCategoryProductImpl extends GenericCreateService<CategoryProductEntity, CategoryProductDto, Integer> {

    private final CategoryProductRepository categoryProductRepository;
    private final CategoryProductMapper categoryProductMapper;

    public CreateCategoryProductImpl(CategoryProductRepository categoryProductRepository, CategoryProductMapper categoryProductMapper) {
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
    public CategoryProductEntity toEntity(CategoryProductDto categoryProductDto) {
        return this.categoryProductMapper.toEntityIgnoredId(categoryProductDto);
    }

    @Override
    public void verifyUnique(CategoryProductDto categoryProductDto) {
        Boolean existsCode = this.categoryProductRepository.existsByCode(categoryProductDto.getCode());
        Boolean existsName = this.categoryProductRepository.existsByName(categoryProductDto.getName());
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, categoryProductDto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, categoryProductDto.getName());
    }

}