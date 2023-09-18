package com.z4greed.core.models.mapper;

import com.shared.dto.GenreDto;
import com.z4greed.core.models.entity.GenreEntity;
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