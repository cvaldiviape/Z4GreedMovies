package com.catalogs.core.entity.mapper;

import com.catalogs.core.entity.GenreEntity;
import com.catalogs.core.entity.StudioEntity;
import com.shared.dto.GenreDto;
import com.shared.dto.StudioDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {CountryMapper.class})
public interface StudioMapper {

    public StudioDto toDto(StudioEntity entity);
    public StudioEntity toEntity(StudioDto dto);
    List<StudioDto> toListDtos(List<StudioEntity> listEntities);
    List<StudioEntity> toListEntities(List<StudioDto> listDtos);
    @Mapping(target = "idStudio", ignore = true)
    void updateEntityFromDto(StudioDto dto, @MappingTarget StudioEntity entity);

}