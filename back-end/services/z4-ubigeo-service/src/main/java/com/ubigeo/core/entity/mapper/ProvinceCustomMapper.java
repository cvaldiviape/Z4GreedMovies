package com.ubigeo.core.entity.mapper;

import com.shared.dto.DepartmentDto;
import com.shared.dto.ProvinceDto;
import com.ubigeo.core.entity.ProvinceEntity;
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
