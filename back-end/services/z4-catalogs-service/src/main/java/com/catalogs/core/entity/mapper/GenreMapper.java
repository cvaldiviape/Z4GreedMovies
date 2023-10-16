package com.catalogs.core.entity.mapper;

import com.shared.dto.GenreDto;
import com.catalogs.core.entity.GenreEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface GenreMapper {

    public GenreDto toDto(GenreEntity entity);
    public GenreEntity toEntity(GenreDto dto);
    List<GenreDto> toListDtos(List<GenreEntity> listEntities);
    List<GenreEntity> toListEntities(List<GenreDto> listDtos);
    @Mapping(target = "idGenre", ignore = true)
    void updateEntityFromDto(GenreDto dto, @MappingTarget GenreEntity entity);

}