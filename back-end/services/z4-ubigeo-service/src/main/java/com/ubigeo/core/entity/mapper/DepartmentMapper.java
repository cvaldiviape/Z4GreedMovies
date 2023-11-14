package com.ubigeo.core.entity.mapper;

import com.shared.dto.DepartmentDto;
import com.ubigeo.core.entity.DepartmentEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DepartmentMapper {

    @Named("DepartmentMapper.toDto")
    public DepartmentDto toDto(DepartmentEntity entity);
    @Named("DepartmentMapper.toEntity")
    public DepartmentEntity toEntity(DepartmentDto dto);
    @Named("DepartmentMapper.toListDtos")
    List<DepartmentDto> toListDtos(List<DepartmentEntity> listEntities);
    @Named("DepartmentMapper.toListEntities")
    List<DepartmentEntity> toListEntities(List<DepartmentDto> listDtos);
    @Named("DepartmentMapper.updateEntityFromDto")
    void updateEntityFromDto(DepartmentDto dto, @MappingTarget DepartmentEntity entity);
    @Named("DepartmentMapper.updateEntityFromDtoIgnoredId")
    @Mapping(target = "idDepartment", ignore = true)
    void updateEntityFromDtoIgnoredId(DepartmentDto dto, @MappingTarget DepartmentEntity entity);


}