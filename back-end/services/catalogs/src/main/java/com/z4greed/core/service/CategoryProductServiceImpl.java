package com.z4greed.core.service;

import com.z4greed.core.models.dto.CategoryProductDto;
import com.z4greed.core.models.entity.CategoryProductEntity;
import com.z4greed.core.models.mapper.CategoryProductMapper;
import com.z4greed.core.repository.CategoryProductRepository;
import com.z4greed.core.service.common.HandlerCrudService;
import com.z4greed.shared.exception.ResourceNotFoundException;
import com.z4greed.shared.utils.ValidateUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("categoryProductServiceImpl")
@Transactional
public class CategoryProductServiceImpl extends HandlerCrudService<CategoryProductEntity, CategoryProductDto, Integer> {

    private final CategoryProductRepository categoryProductRepository;
    private final CategoryProductMapper categoryProductMapper;

    public CategoryProductServiceImpl(CategoryProductRepository categoryProductRepository, CategoryProductMapper categoryProductMapper){
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
    public void updateEntityFromDto(CategoryProductDto dto, CategoryProductEntity entity) {
        this.categoryProductMapper.updateEntityFromDto(dto, entity);
    }

    @Override
    public CategoryProductEntity findById(Integer id) {
        return this.categoryProductRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id", id));
    }

    @Override
    public void verifyUnique(CategoryProductDto dto) {
        Boolean existsCode = this.categoryProductRepository.existsByCode(dto.getCode());
        ValidateUtil.evaluate(existsCode, "The code " + dto.getCode() + " already exists.");
        Boolean existsName = this.categoryProductRepository.existsByName(dto.getName());
        ValidateUtil.evaluate(existsName, "The name " + dto.getName() + " already exists.");
    }

    @Override
    public void verifyUnique(Integer id, CategoryProductDto dto) {
        Boolean existsCode = this.categoryProductRepository.existsByCodeAndIdCategoryProductNot(dto.getCode(), id);
        ValidateUtil.evaluate(existsCode, "The code " + dto.getCode() + " already exists.");
        Boolean existsName = this.categoryProductRepository.existsByNameAndIdCategoryProductNot(dto.getName(), id);
        ValidateUtil.evaluate(existsName, "The name " + dto.getName() + " already exists.");
    }

}