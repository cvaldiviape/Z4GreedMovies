package com.ubigeo.core.entity.mapper;

import com.shared.dto.external.ubigeo.DepartmentDto;
import com.ubigeo.core.entity.DepartmentEntity;
import org.mapstruct.*;
import java.util.Collection;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DepartmentMapper {

    @Named("DepartmentMapper.toDto")
    DepartmentDto toDto(DepartmentEntity entity);
    @Named("DepartmentMapper.toDtoIgnoredListProvinces")
    @Mapping(target = "listProvinces", ignore = true)
    DepartmentDto toDtoIgnoredListProvinces(DepartmentEntity entity); // use by "ProvinceMapper"
    @Named("DepartmentMapper.toEntityIgnoredId")
    @Mapping(target = "idDepartment", ignore = true)
    DepartmentEntity toEntityIgnoredId(DepartmentDto dto);
    @Named("DepartmentMapper.toListEntities")
    Collection<DepartmentEntity> toListEntities(Collection<DepartmentDto> listDtos);
    @Named("DepartmentMapper.updateEntityFromDto")
    void updateEntityFromDto(DepartmentDto dto, @MappingTarget DepartmentEntity entity); // use by "ProvinceMapper"
    @Named("DepartmentMapper.updateEntityFromDtoIgnoredId")
    @Mapping(target = "idDepartment", ignore = true)
    void updateEntityFromDtoIgnoredId(DepartmentDto dto, @MappingTarget DepartmentEntity entity);

}