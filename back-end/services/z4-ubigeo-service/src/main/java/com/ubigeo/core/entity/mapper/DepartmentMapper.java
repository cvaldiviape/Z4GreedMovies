package com.ubigeo.core.entity.mapper;

import com.shared.dto.DepartmentDto;
import com.ubigeo.core.entity.DepartmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DepartmentMapper {

    public DepartmentDto toDto(DepartmentEntity entity);
    public DepartmentEntity toEntity(DepartmentDto dto);
    List<DepartmentDto> toListDtos(List<DepartmentEntity> listEntities);
    List<DepartmentEntity> toListEntities(List<DepartmentDto> listDtos);
    @Mapping(target = "idDepartment", ignore = true)
    void updateEntityFromDto(DepartmentDto dto, @MappingTarget DepartmentEntity entity);

}