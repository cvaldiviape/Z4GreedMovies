package com.ubigeo.core.entity.mapper;

import com.shared.dto.DepartmentDto;
import com.shared.dto.ProvinceDto;
import com.ubigeo.core.entity.DepartmentEntity;
import com.ubigeo.core.entity.ProvinceEntity;
import org.mapstruct.*;
import java.util.Collection;
import java.util.Set;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DepartmentCustomMapper {

    @Named("DepartmentCustomMapper.toListDtos")
    @IterableMapping(qualifiedByName = "DepartmentCustomMapper.toDto")
    Collection<DepartmentDto> toListDtos(Collection<DepartmentEntity> listDepartmentsEntities); // department
    @Named("DepartmentCustomMapper.toDto")
    @Mapping(target = "listProvinces", qualifiedByName = "DepartmentCustomMapper.toListDtosIgnoredDepartment")
    DepartmentDto toDto(DepartmentEntity departmentEntity); // department
    @Named("DepartmentCustomMapper.toListDtosIgnoredDepartment")
    @IterableMapping(qualifiedByName = "DepartmentCustomMapper.toDtoIgnoredDepartment")
    Set<ProvinceDto> toListDtosIgnoredDepartment(Set<ProvinceEntity> listProvincesEntities); // province
    @Named("DepartmentCustomMapper.toDtoIgnoredDepartment")
    @Mapping(target = "department", ignore = true)
    ProvinceDto toDtoIgnoredDepartment(ProvinceEntity provinceEntity); // province

}