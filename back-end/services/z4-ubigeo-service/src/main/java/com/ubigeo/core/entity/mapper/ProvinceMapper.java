package com.ubigeo.core.entity.mapper;

import com.shared.dto.ProvinceDto;
import com.ubigeo.core.entity.ProvinceEntity;
import org.mapstruct.*;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {DepartmentMapper.class})
public interface ProvinceMapper {

    @Named("ProvinceMapper.toDto")
    public ProvinceDto toDto(ProvinceEntity entity);
    @Named("ProvinceMapper.toEntity")
    public ProvinceEntity toEntity(ProvinceDto dto);
    @Named("ProvinceMapper.toEntityIngoredId")
    @Mapping(target = "idProvince", ignore = true)
    public ProvinceEntity toEntityIngoredId(ProvinceDto dto);
    @Named("ProvinceMapper.toListDtos")
    Collection<ProvinceDto> toListDtos(Collection<ProvinceEntity> listEntities);
    @Named("ProvinceMapper.toListEntities")
    Collection<ProvinceEntity> toListEntities(Collection<ProvinceDto> listDtos);
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