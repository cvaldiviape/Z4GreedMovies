package com.ubigeo.core.entity.mapper.custom;

import com.shared.dto.external.ubigeo.ProvinceDto;
import com.ubigeo.core.entity.ProvinceEntity;
import com.ubigeo.core.entity.mapper.DepartmentMapper;
import org.mapstruct.*;
import java.util.Collection;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {DepartmentMapper.class})
public interface ProvinceCustomMapper {

    @Named("ProvinceCustomMapper.toListDtos")
    @IterableMapping(qualifiedByName = "ProvinceCustomMapper.toDto")
    Collection<ProvinceDto> toListDtos(Collection<ProvinceEntity> listEntities);
    @Named("ProvinceCustomMapper.toDto")
    @Mapping(target = "department", qualifiedByName = "DepartmentMapper.toDtoIgnoredListProvinces")
    ProvinceDto toDto(ProvinceEntity entity);

}