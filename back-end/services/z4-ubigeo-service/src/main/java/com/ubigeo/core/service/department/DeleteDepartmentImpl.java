package com.ubigeo.core.service.department;

import com.ubigeo.core.entity.DepartmentEntity;
import com.ubigeo.core.entity.mapper.DepartmentMapper;
import com.ubigeo.core.repository.DepartmentRepository;
import com.shared.core.service.impl.GenericDeleteService;
import com.shared.dto.DepartmentDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("deleteDepartmentImpl")
public class DeleteDepartmentImpl extends GenericDeleteService<DepartmentEntity, DepartmentDto, Integer> {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public DeleteDepartmentImpl(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
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
    public DepartmentEntity findEntityById(Integer idDepartment) {
        return this.departmentRepository.findById(idDepartment)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.DEPARTMENT.getValue(), idDepartment));
    }

}