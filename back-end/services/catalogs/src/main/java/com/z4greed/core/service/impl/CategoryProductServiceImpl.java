package com.z4greed.core.service.impl;

import com.shared.dto.CategoryProductDto;
import com.shared.enums.ValueEnum;
import com.shared.error.GeneralErrorEnum;
import com.shared.utils.ValidateUtil;
import com.z4greed.core.models.entity.CategoryProductEntity;
import com.z4greed.core.models.mapper.CategoryProductMapper;
import com.z4greed.core.repository.CategoryProductRepository;
import com.z4greed.core.service.CategoryProductService;
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
    public List<CategoryProductDto> toListDtos(List<CategoryProductEntity> listEntities) {
        return this.categoryProductMapper.toListDtos(listEntities);
    }

    @Override
    public void updateEntityFromDto(CategoryProductDto dto, CategoryProductEntity entity) {
        this.categoryProductMapper.updateEntityFromDto(dto, entity);
    }

    @Override
    public CategoryProductEntity findEntityById(Integer id) {
        return this.categoryProductRepository.findById(id)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.CATEGORY.getValue(), id));
    }

    @Override
    public void verifyUnique(CategoryProductDto dto) {
        Boolean existsCode = this.categoryProductRepository.existsByCode(dto.getCode());
        ValidateUtil.evaluateTrue(existsCode, GeneralErrorEnum.ER000005, ValueEnum.CODE.getValue(), dto.getCode());
        Boolean existsName = this.categoryProductRepository.existsByName(dto.getName());
        ValidateUtil.evaluateTrue(existsName, GeneralErrorEnum.ER000005, ValueEnum.NAME.getValue(), dto.getName());
    }

    @Override
    public void verifyUnique(Integer id, CategoryProductDto dto) {
        Boolean existsCode = this.categoryProductRepository.existsByCodeAndIdCategoryProductNot(dto.getCode(), id);
        ValidateUtil.evaluateTrue(existsCode, GeneralErrorEnum.ER000005, ValueEnum.CODE.getValue(), dto.getCode());
        Boolean existsName = this.categoryProductRepository.existsByNameAndIdCategoryProductNot(dto.getName(), id);
        ValidateUtil.evaluateTrue(existsName, GeneralErrorEnum.ER000005, ValueEnum.NAME.getValue(), dto.getName());
    }

    @Override
    public List<CategoryProductDto> findAllByListIds(Collection<Integer> listIds) {
        List<CategoryProductEntity> listEntities = this.categoryProductRepository.findAllById(listIds);
        return this.toListDtos(listEntities);
    }

}