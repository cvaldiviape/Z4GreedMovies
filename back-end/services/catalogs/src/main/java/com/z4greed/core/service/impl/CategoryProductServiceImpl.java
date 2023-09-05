package com.z4greed.core.service.impl;

import com.z4greed.core.models.dto.CategoryProductDto;
import com.z4greed.core.models.dto.base.BasePageDto;
import com.z4greed.core.models.entity.CategoryProductEntity;
import com.z4greed.core.repository.CategoryProductRepository;
import com.z4greed.core.service.CategoryProductService;
import com.z4greed.shared.exception.Z4GreedMoviesException;
import com.z4greed.shared.exception.ResourceNotFoundException;
import com.z4greed.core.models.mapper.CategoryProductMapper;
import com.z4greed.shared.utils.PageUtil;
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
        this.verifyUnique(dto.getName());
        this.verifyUnique(dto.getCode());

        CategoryProductEntity entity = this.categoryProductMapper.toEntity(dto);
        this.categoryProductRepository.save(entity);
        return this.categoryProductMapper.toDto(entity);
    }

    @Override
    public CategoryProductDto update(Integer id, CategoryProductDto dto) {
        CategoryProductEntity entity = this.getCategoryById(id);

        this.verifyUnique(dto.getCode(), entity.getCode());
        this.verifyUnique(dto.getName(), entity.getName());

        this.categoryProductMapper.updateEntityFromDto(dto, entity);
        this.categoryProductRepository.save(entity);
        return this.categoryProductMapper.toDto(entity);
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

    public void verifyUnique(String value) {
        Boolean existsValue = this.categoryProductRepository.existsByName(value);
        if (existsValue) {
            throw new Z4GreedMoviesException(HttpStatus.BAD_REQUEST, "The name " + value + " already exists.");
        }
    }

    public void verifyUnique(String value, String valueCurrent) {
        Boolean existsValue = this.categoryProductRepository.existsByName(value);
        Boolean diferentValueCurrent = (!value.equalsIgnoreCase(valueCurrent));
        if(existsValue && diferentValueCurrent) {
            throw new Z4GreedMoviesException(HttpStatus.BAD_REQUEST, "The name " + value + " already exists.");
        }
    }

}