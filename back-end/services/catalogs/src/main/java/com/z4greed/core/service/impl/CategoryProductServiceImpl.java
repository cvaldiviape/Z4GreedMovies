package com.z4greed.core.service.impl;

import com.z4greed.core.models.dto.CategoryProductDto;
import com.z4greed.core.models.entity.CategoryProductEntity;
import com.z4greed.core.repository.CategoryProductRepository;
import com.z4greed.core.service.common.HandlerCrudService;
import com.z4greed.shared.exception.ResourceNotFoundException;
import com.z4greed.core.models.mapper.CategoryProductMapper;
import com.z4greed.shared.utils.ValidateUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
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


//    @Override
//    public BasePageDto<CategoryProductDto> getAll(Integer numberPage, Integer sizePage, String sortBy, String sortDir) {
//        Pageable pageable = PageUtil.getPageable(numberPage, sizePage, sortBy, sortDir);
//        Page<CategoryProductEntity> pageData = this.categoryProductRepository.findAll(pageable);
//        List<CategoryProductEntity> listEntities = pageData.getContent();
//
//        List<CategoryProductDto> listDtos = listEntities.stream()
//                .map(this.categoryProductMapper::toDto)
//                .collect(Collectors.toList());
//
//        return BasePageDto.<CategoryProductDto>builder()
//                .listElements(listDtos)
//                .numberPage(pageData.getNumber())
//                .sizePage(pageData.getSize())
//                .totalElements(pageData.getTotalElements())
//                .totalPages(pageData.getTotalPages())
//                .isLastPage(pageData.isLast())
//                .build();
//    }


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