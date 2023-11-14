package com.ubigeo.core.service.department;

import com.ubigeo.core.entity.DepartmentEntity;
import com.ubigeo.core.entity.mapper.DepartmentMapper;
import com.ubigeo.core.repository.DepartmentRepository;
import com.shared.core.service.impl.GenericUpdateService;
import com.shared.dto.DepartmentDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("updateDepartmentImpl")
public class UpdateDepartmentImpl extends GenericUpdateService<DepartmentEntity, DepartmentDto, Integer> {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public UpdateDepartmentImpl(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
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
    public void updateEntityFromDto(DepartmentDto departmentDto, DepartmentEntity departmentEntity) {
        this.departmentMapper.updateEntityFromDtoIgnoredId(departmentDto, departmentEntity);
    }

    @Override
    public DepartmentEntity findEntityById(Integer idDepartment) {
        return this.departmentRepository.findById(idDepartment)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.DEPARTMENT.getValue(), idDepartment));
    }

    @Override
    public void verifyUnique(Integer idDepartment, DepartmentDto departmentDto) {
        Boolean existsCode = this.departmentRepository.existsByCodeAndIdDepartmentNot(departmentDto.getCode(), idDepartment);
        Boolean existsName = this.departmentRepository.existsByNameAndIdDepartmentNot(departmentDto.getName(), idDepartment);
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, departmentDto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, departmentDto.getName());
    }

}