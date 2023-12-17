package com.ubigeo.core.service.department;

import com.ubigeo.core.entity.DepartmentEntity;
import com.ubigeo.core.entity.mapper.DepartmentMapper;
import com.ubigeo.core.repository.DepartmentRepository;
import com.shared.core.service.impl.GenericCreateService;
import com.shared.dto.external.ubigeo.DepartmentDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("createDepartmentImpl")
public class CreateDepartmentImpl extends GenericCreateService<DepartmentEntity, DepartmentDto, Integer> {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public CreateDepartmentImpl(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    @Override
    public JpaRepository<DepartmentEntity, Integer> getJpaRepository() {
        return this.departmentRepository;
    }

    @Override
    public DepartmentDto toDto(DepartmentEntity departmentEntity) {
        return this.departmentMapper.toDto(departmentEntity);
    }

    @Override
    public DepartmentEntity toEntity(DepartmentDto departmentDto) {
        return this.departmentMapper.toEntityIgnoredId(departmentDto);
    }

    @Override
    public void verifyUnique(DepartmentDto departmentDto) {
        Boolean existsCode = this.departmentRepository.existsByCode(departmentDto.getCode());
        Boolean existsName = this.departmentRepository.existsByName(departmentDto.getName());
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, departmentDto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, departmentDto.getName());
    }

}