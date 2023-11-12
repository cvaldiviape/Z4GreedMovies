package com.catalogs.core.entity.mapper;

import com.shared.dto.MovieAudienceDto;
import com.catalogs.core.entity.MovieAudienceEntity;
import org.mapstruct.*;
import java.util.Collection;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MovieAudienceMapper {

    @Named("MovieAudienceMapper.toDto")
    public MovieAudienceDto toDto(MovieAudienceEntity entity);
    @Named("MovieAudienceMapper.toEntity")
    public MovieAudienceEntity toEntity(MovieAudienceDto dto);
    @Named("MovieAudienceMapper.toEntityIgnoredId")
    @Mapping(target = "idMovieAudience", ignore = true)
    public MovieAudienceEntity toEntityIgnoredId(MovieAudienceDto dto);
    @Named("MovieAudienceMapper.toListDtos")
    Collection<MovieAudienceDto> toListDtos(Collection<MovieAudienceEntity> listEntities);
    @Named("MovieAudienceMapper.toListEntities")
    Collection<MovieAudienceEntity> toListEntities(Collection<MovieAudienceDto> listDtos);
    @Named("MovieAudienceMapper.updateEntityFromDto")
    void updateEntityFromDto(MovieAudienceDto dto, @MappingTarget MovieAudienceEntity entity);
    @Named("MovieAudienceMapper.updateEntityFromDtoIgnoredId")
    @Mapping(target = "idMovieAudience", ignore = true)
    void updateEntityFromDtoIgnoredId(MovieAudienceDto dto, @MappingTarget MovieAudienceEntity entity);

}