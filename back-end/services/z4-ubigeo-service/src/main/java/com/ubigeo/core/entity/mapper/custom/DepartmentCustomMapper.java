package com.ubigeo.core.entity.mapper.custom;

import com.shared.dto.external.ubigeo.DepartmentDto;
import com.shared.dto.external.ubigeo.DistrictDto;
import com.shared.dto.external.ubigeo.ProvinceDto;
import com.ubigeo.core.entity.DepartmentEntity;
import com.ubigeo.core.entity.DistrictEntity;
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
    @Mapping(target = "listProvinces", qualifiedByName = "DepartmentCustomMapper.toListProvincesDtosIgnoredDepartment")
    DepartmentDto toDto(DepartmentEntity departmentEntity); // department
    @Named("DepartmentCustomMapper.toListProvincesDtosIgnoredDepartment")
    @IterableMapping(qualifiedByName = "DepartmentCustomMapper.toProvinceDtoIgnoredDepartment")
    Set<ProvinceDto> toListProvincesDtosIgnoredDepartment(Set<ProvinceEntity> listProvincesEntities); // province
    @Named("DepartmentCustomMapper.toProvinceDtoIgnoredDepartment")
    @Mapping(target = "department", ignore = true)
    @Mapping(target = "listDistricts", qualifiedByName = "DepartmentCustomMapper.toLisDistrictstDtosIgnoredProvice")
    ProvinceDto toProvinceDtoIgnoredDepartment(ProvinceEntity provinceEntity); // province
    @Named("DepartmentCustomMapper.toLisDistrictstDtosIgnoredProvice")
    @IterableMapping(qualifiedByName = "DepartmentCustomMapper.toDistrictDtoIgnoredProvince")
    Set<DistrictDto> toLisDistrictstDtosIgnoredProvice(Set<DistrictEntity> listDistrictsEntities); // district
    @Named("DepartmentCustomMapper.toDistrictDtoIgnoredProvince")
    @Mapping(target = "province", ignore = true)
    DistrictDto toDistrictDtoIgnoredProvince(DistrictEntity districtEntity); // district

}