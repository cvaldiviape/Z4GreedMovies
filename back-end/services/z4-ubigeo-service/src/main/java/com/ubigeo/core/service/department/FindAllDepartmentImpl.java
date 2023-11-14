package com.ubigeo.core.service.department;

import com.ubigeo.core.entity.DepartmentEntity;
import com.ubigeo.core.entity.mapper.DepartmentMapper;
import com.ubigeo.core.repository.DepartmentRepository;
import com.shared.core.service.impl.GenericFindAllService;
import com.shared.dto.DepartmentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service("findAllDepartmentImpl")
public class FindAllDepartmentImpl extends GenericFindAllService<DepartmentEntity, DepartmentDto, Integer> {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public FindAllDepartmentImpl(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    @Override
    public JpaRepository<DepartmentEntity, Integer> getJpaRepository() {
        return this.departmentRepository;
    }

    @Override
    public Collection<DepartmentDto> toListDtos(Collection<DepartmentEntity> listEntities) {
        return this.departmentMapper.toListDtos(listEntities);
    }

}