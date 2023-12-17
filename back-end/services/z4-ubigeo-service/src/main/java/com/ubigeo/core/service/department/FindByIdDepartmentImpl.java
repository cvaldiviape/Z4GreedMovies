package com.ubigeo.core.service.department;

import com.ubigeo.core.entity.DepartmentEntity;
import com.ubigeo.core.entity.mapper.DepartmentCustomMapper;
import com.ubigeo.core.repository.DepartmentRepository;
import com.shared.core.service.impl.GenericFindByIdService;
import com.shared.dto.DepartmentDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.stereotype.Service;

@Service("findByIdDepartmentImpl")
public class FindByIdDepartmentImpl extends GenericFindByIdService<DepartmentEntity, DepartmentDto, Integer> {

    private final DepartmentRepository departmentRepository;
    private final DepartmentCustomMapper commonMapper;

    public FindByIdDepartmentImpl(DepartmentRepository departmentRepository, DepartmentCustomMapper commonMapper) {
        this.departmentRepository = departmentRepository;
        this.commonMapper = commonMapper;
    }

    @Override
    public DepartmentDto toDto(DepartmentEntity departmentEntity) {
        return this.commonMapper.toDto(departmentEntity);
    }

    @Override
    public DepartmentEntity findEntityById(Integer idDepartment) {
        return this.departmentRepository.findById(idDepartment)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.DEPARTMENT.getValue(), idDepartment));
    }

}