package com.catalogs.core.service.impl;

import com.shared.dto.CategoryProductDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import com.catalogs.core.entity.CategoryProductEntity;
import com.catalogs.core.entity.mapper.CategoryProductMapper;
import com.catalogs.core.repository.CategoryProductRepository;
import com.catalogs.core.service.CategoryProductService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.List;

@Service("categoryProductServiceImpl")
@Transactional
public class CategoryProductServiceImpl extends CategoryProductService<CategoryProductEntity, CategoryProductDto, Integer> {

    private final CategoryProductRepository categoryProductRepository;
    private final CategoryProductMapper categoryProductMapper;

    public CategoryProductServiceImpl(CategoryProductRepository categoryProductRepository, CategoryProductMapper categoryProductMapper) {
        this.categoryProductRepository = categoryProductRepository;
        this.categoryProductMapper = categoryProductMapper;
    }

    @Override
    public JpaRepository<CategoryProductEntity, Integer> getJpaRepository() {
        return this.categoryProductRepository;
    }

    @Override
    public CategoryProductDto toDto(CategoryProductEntity entity){
        return this.categoryProductMapper.toDto(entity);
    }

    @Override
    public CategoryProductEntity toEntity(CategoryProductDto dto){
        return this.categoryProductMapper.toEntity(dto);
    }

    @Override
    public Collection<CategoryProductDto> toListDtos(Collection<CategoryProductEntity> listEntities) {
        return this.categoryProductMapper.toListDtos(listEntities);
    }

    @Override
    public void updateEntityFromDto(CategoryProductDto dto, CategoryProductEntity entity) {
        this.categoryProductMapper.updateEntityFromDtoIgnoredId(dto, entity);
    }

    @Override
    public CategoryProductEntity findEntityById(Integer id) {
        return this.categoryProductRepository.findById(id)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.CATEGORY.getValue(), id));
    }

    @Override
    public void verifyUnique(CategoryProductDto dto) {
        Boolean existsCode = this.categoryProductRepository.existsByCode(dto.getCode());
        Boolean existsName = this.categoryProductRepository.existsByName(dto.getName());
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, dto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, dto.getName());
    }

    @Override
    public void verifyUnique(Integer id, CategoryProductDto dto) {
        Boolean existsCode = this.categoryProductRepository.existsByCodeAndIdCategoryProductNot(dto.getCode(), id);
        Boolean existsName = this.categoryProductRepository.existsByNameAndIdCategoryProductNot(dto.getName(), id);
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, dto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, dto.getName());
    }

    @Override
    public Collection<CategoryProductDto> findAllByListIds(Collection<Integer> listIds) {
        List<CategoryProductEntity> listEntities = this.categoryProductRepository.findAllById(listIds);
        return this.toListDtos(listEntities);
    }

}