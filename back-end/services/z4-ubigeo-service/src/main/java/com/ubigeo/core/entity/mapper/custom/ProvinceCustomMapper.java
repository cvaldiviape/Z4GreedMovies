package com.ubigeo.core.entity.mapper.custom;

import com.shared.dto.external.ubigeo.DistrictDto;
import com.shared.dto.external.ubigeo.ProvinceDto;
import com.ubigeo.core.entity.DistrictEntity;
import com.ubigeo.core.entity.ProvinceEntity;
import com.ubigeo.core.entity.mapper.DepartmentMapper;
import org.mapstruct.*;
import java.util.Collection;
import java.util.Set;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {DepartmentMapper.class})
public interface ProvinceCustomMapper {

    @Named("ProvinceCustomMapper.toListDtos")
    @IterableMapping(qualifiedByName = "ProvinceCustomMapper.toDto")
    Collection<ProvinceDto> toListDtos(Collection<ProvinceEntity> listEntities);
    @Named("ProvinceCustomMapper.toDto")
    @Mapping(target = "department", qualifiedByName = "DepartmentMapper.toDtoIgnoredListProvinces")
    @Mapping(target = "listDistricts", qualifiedByName = "ProvinceCustomMapper.toLisDistrictstDtosIgnoredProvice")
    ProvinceDto toDto(ProvinceEntity entity);
    @Named("ProvinceCustomMapper.toLisDistrictstDtosIgnoredProvice")
    @IterableMapping(qualifiedByName = "ProvinceCustomMapper.toDistrictDtoIgnoredProvince")
    Set<DistrictDto> toLisDistrictstDtosIgnoredProvice(Set<DistrictEntity> listDistrictsEntities); // district
    @Named("ProvinceCustomMapper.toDistrictDtoIgnoredProvince")
    @Mapping(target = "province", ignore = true)
    DistrictDto toDistrictDtoIgnoredProvince(DistrictEntity districtEntity); // district
}