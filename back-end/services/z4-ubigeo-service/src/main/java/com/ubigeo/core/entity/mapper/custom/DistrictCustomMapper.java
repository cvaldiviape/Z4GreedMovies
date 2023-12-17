package com.ubigeo.core.entity.mapper.custom;

import com.shared.dto.DistrictDto;
import com.ubigeo.core.entity.DistrictEntity;
import com.ubigeo.core.entity.mapper.ProvinceMapper;
import org.mapstruct.*;
import java.util.Collection;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {ProvinceMapper.class})
public interface DistrictCustomMapper {

    @Named("DistrictCustomMapper.toListDtos")
    @IterableMapping(qualifiedByName = "DistrictCustomMapper.toDto")
    Collection<DistrictDto> toListDtos(Collection<DistrictEntity> listEntities);
    @Named("DistrictCustomMapper.toDto")
    @Mapping(target = "province", qualifiedByName = "ProvinceMapper.toDtoIgnoredDepartmentAndListDistricts")
    DistrictDto toDto(DistrictEntity entity);

}