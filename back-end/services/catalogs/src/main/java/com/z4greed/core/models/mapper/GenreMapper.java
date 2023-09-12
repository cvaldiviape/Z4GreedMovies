package com.z4greed.core.models.mapper;

import com.z4greed.core.models.dto.GenreDto;
import com.z4greed.core.models.entity.GenreEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface GenreMapper {

    public GenreDto toDto(GenreEntity entity);
    public GenreEntity toEntity(GenreDto dto);
    @Mapping(target = "idGenre", ignore = true)
    void updateEntityFromDto(GenreDto dto, @MappingTarget GenreEntity entity);

}