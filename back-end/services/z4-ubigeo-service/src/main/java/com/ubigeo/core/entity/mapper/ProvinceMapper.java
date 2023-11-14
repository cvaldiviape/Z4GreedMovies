package com.ubigeo.core.entity.mapper;

import com.shared.dto.ProvinceDto;
import com.ubigeo.core.entity.ProvinceEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {DepartmentMapper.class})
public interface ProvinceMapper {

    @Named("ProvinceMapper.toDto")
    public ProvinceDto toDto(ProvinceEntity entity);
    @Named("ProvinceMapper.toEntity")
    public ProvinceEntity toEntity(ProvinceDto dto);
    @Named("ProvinceMapper.toListDtos")
    List<ProvinceDto> toListDtos(List<ProvinceEntity> listEntities);
    @Named("ProvinceMapper.toListEntities")
    List<ProvinceEntity> toListEntities(List<ProvinceDto> listDtos);
    @Named("ProvinceMapper.updateEntityFromDto")
    @Mappings({
            @Mapping(target = "department", qualifiedByName = "DepartmentMapper.updateEntityFromDto"),
    })
    void updateEntityFromDto(ProvinceDto dto, @MappingTarget ProvinceEntity entity);
    @Named("ProvinceMapper.updateEntityFromDtoIgnoredId")
    @Mappings({
            @Mapping(target = "idProvince", ignore = true),
            @Mapping(target = "department", qualifiedByName = "DepartmentMapper.updateEntityFromDto"),
    })
    void updateEntityFromDtoIgnoredId(ProvinceDto dto, @MappingTarget ProvinceEntity entity);

}