package com.catalogs.core.entity.mapper;

import com.shared.dto.GenreDto;
import com.catalogs.core.entity.GenreEntity;
import org.mapstruct.*;

import java.util.Collection;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface GenreMapper {

    public GenreDto toDto(GenreEntity entity);
    public GenreEntity toEntity(GenreDto dto);
    Collection<GenreDto> toListDtos(Collection<GenreEntity> listEntities);
    Collection<GenreEntity> toListEntities(Collection<GenreDto> listDtos);
    @Named("GenreMapper.updateEntityFromDto")
    void updateEntityFromDto(GenreDto dto, @MappingTarget GenreEntity entity);
    @Named("GenreMapper.updateEntityFromDtoIgnoredId")
    @Mapping(target = "idGenre", ignore = true)
    void updateEntityFromDtoIgnoredId(GenreDto dto, @MappingTarget GenreEntity entity);


}