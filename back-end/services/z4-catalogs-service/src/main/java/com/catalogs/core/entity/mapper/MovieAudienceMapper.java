package com.catalogs.core.entity.mapper;

import com.shared.dto.MovieAudienceDto;
import com.catalogs.core.entity.MovieAudienceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MovieAudienceMapper {

    public MovieAudienceDto toDto(MovieAudienceEntity entity);
    public MovieAudienceEntity toEntity(MovieAudienceDto dto);
    List<MovieAudienceDto> toListDtos(List<MovieAudienceEntity> listEntities);
    List<MovieAudienceEntity> toListEntities(List<MovieAudienceDto> listDtos);
    @Mapping(target = "idMovieAudience", ignore = true)
    void updateEntityFromDto(MovieAudienceDto dto, @MappingTarget MovieAudienceEntity entity);

}