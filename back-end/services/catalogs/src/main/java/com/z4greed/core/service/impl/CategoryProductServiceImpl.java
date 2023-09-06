package com.z4greed.core.service.impl;

import com.z4greed.core.models.dto.CategoryProductDto;
import com.z4greed.core.models.common.BasePageDto;
import com.z4greed.core.models.entity.CategoryProductEntity;
import com.z4greed.core.repository.CategoryProductRepository;
import com.z4greed.core.service.CategoryProductService;
import com.z4greed.shared.exception.Z4GreedMoviesException;
import com.z4greed.shared.exception.ResourceNotFoundException;
import com.z4greed.core.models.mapper.CategoryProductMapper;
import com.z4greed.shared.utils.PageUtil;
import com.z4greed.shared.utils.ValidateUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CategoryProductServiceImpl implements CategoryProductService {

    private final CategoryProductRepository categoryProductRepository;
    private final CategoryProductMapper categoryProductMapper;

    public CategoryProductServiceImpl(CategoryProductRepository categoryProductRepository, CategoryProductMapper categoryProductMapper){
        this.categoryProductRepository = categoryProductRepository;
        this.categoryProductMapper = categoryProductMapper;
    }

    @Override
    public BasePageDto<CategoryProductDto> getAll(Integer numberPage, Integer sizePage, String sortBy, String sortDir) {
        Pageable pageable = PageUtil.getPageable(numberPage, sizePage, sortBy, sortDir);
        Page<CategoryProductEntity> pageData = this.categoryProductRepository.findAll(pageable);
        List<CategoryProductEntity> listEntities = pageData.getContent();

        List<CategoryProductDto> listDtos = listEntities.stream()
                .map(this.categoryProductMapper::toDto)
                .collect(Collectors.toList());

        return BasePageDto.<CategoryProductDto>builder()
                .listElements(listDtos)
                .numberPage(pageData.getNumber())
                .sizePage(pageData.getSize())
                .totalElements(pageData.getTotalElements())
                .totalPages(pageData.getTotalPages())
                .isLastPage(pageData.isLast())
                .build();
    }

    @Override
    public CategoryProductDto getById(Integer id) {
        CategoryProductEntity entity = this.getCategoryById(id);
        return this.categoryProductMapper.toDto(entity);
    }

    @Override
    public CategoryProductDto create(CategoryProductDto dto) {
        this.verifyUnique(dto);
        CategoryProductEntity entity = this.categoryProductMapper.toEntity(dto);
        CategoryProductEntity entityCreated = this.categoryProductRepository.save(entity);
        return this.categoryProductMapper.toDto(entityCreated);
    }

    @Override
    public CategoryProductDto update(Integer id, CategoryProductDto dto) {
        CategoryProductEntity entity = this.getCategoryById(id);
        this.verifyUnique(id, dto);
        this.categoryProductMapper.updateEntityFromDto(dto, entity);
        CategoryProductEntity entityUpdated = this.categoryProductRepository.save(entity);
        return this.categoryProductMapper.toDto(entityUpdated);
    }

    @Override
    public CategoryProductDto delete(Integer id) {
        CategoryProductEntity entity = this.getCategoryById(id);
        this.categoryProductRepository.delete(entity);
        return this.categoryProductMapper.toDto(entity);
    }

    // ----------------------------------------------------------- utils ----------------------------------------------------------- //
    public CategoryProductEntity getCategoryById(Integer id) {
        return this.categoryProductRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id", id));
    }

    private void verifyUnique(CategoryProductDto dto){
        Boolean existsCode = this.categoryProductRepository.existsByCode(dto.getCode());
        ValidateUtil.evaluate(existsCode, "The code " + dto.getCode() + " already exists.");
        Boolean existsName = this.categoryProductRepository.existsByName(dto.getName());
        ValidateUtil.evaluate(existsName, "The name " + dto.getName() + " already exists.");
    }

    private void verifyUnique(Integer id, CategoryProductDto dto){
        Boolean existsCode = this.categoryProductRepository.existsByCodeAndIdCategoryProductNot(dto.getCode(), id);
        ValidateUtil.evaluate(existsCode, "The code " + dto.getCode() + " already exists.");
        Boolean existsName = this.categoryProductRepository.existsByNameAndIdCategoryProductNot(dto.getName(), id);
        ValidateUtil.evaluate(existsName, "The name " + dto.getName() + " already exists.");
    }

}