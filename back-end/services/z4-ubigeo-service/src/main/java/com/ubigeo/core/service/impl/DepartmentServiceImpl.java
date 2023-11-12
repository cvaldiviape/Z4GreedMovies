package com.ubigeo.core.service.impl;

import com.shared.dto.DepartmentDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import com.ubigeo.core.entity.DepartmentEntity;
import com.ubigeo.core.entity.mapper.DepartmentMapper;
import com.ubigeo.core.repository.DepartmentRepository;
import com.ubigeo.core.service.DepartmentService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.List;

@Service("departmentServiceImpl")
@Transactional
public class DepartmentServiceImpl extends DepartmentService<DepartmentEntity, DepartmentDto, Integer> {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    @Override
    public JpaRepository<DepartmentEntity, Integer> getJpaRepository() {
        return this.departmentRepository;
    }

    @Override
    public DepartmentDto toDto(DepartmentEntity entity) {
        return this.departmentMapper.toDto(entity);
    }

    @Override
    public DepartmentEntity toEntity(DepartmentDto dto) {
        return this.departmentMapper.toEntity(dto);
    }

    @Override
    public List<DepartmentDto> toListDtos(List<DepartmentEntity> listEntities) {
        return this.departmentMapper.toListDtos(listEntities);
    }

    @Override
    public void updateEntityFromDto(DepartmentDto dto, DepartmentEntity entity) {
        this.departmentMapper.updateEntityFromDto(dto, entity);
    }

    @Override
    public DepartmentEntity findEntityById(Integer id) {
        return this.departmentRepository.findById(id)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.DEPARTMENT.getValue(), id));
    }

    @Override
    public void verifyUnique(DepartmentDto dto) {
        Boolean existsCode = this.departmentRepository.existsByCode(dto.getCode());
        Boolean existsName = this.departmentRepository.existsByName(dto.getName());
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, dto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, dto.getName());
    }

    @Override
    public void verifyUnique(Integer id, DepartmentDto dto) {
        Boolean existsCode = this.departmentRepository.existsByCodeAndIdDepartmentNot(dto.getCode(), id);
        Boolean existsName = this.departmentRepository.existsByNameAndIdDepartmentNot(dto.getName(), id);
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, dto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, dto.getName());
    }

    @Override
    public List<DepartmentDto> findAllByListIds(Collection<Integer> listIds) {
        List<DepartmentEntity> listEntities = this.departmentRepository.findAllById(listIds);
        return this.toListDtos(listEntities);
    }

}