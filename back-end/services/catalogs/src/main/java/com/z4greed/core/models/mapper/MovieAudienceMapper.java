package com.z4greed.core.models.mapper;

import com.z4greed.core.models.dto.GenreDto;
import com.z4greed.core.models.dto.MovieAudienceDto;
import com.z4greed.core.models.entity.GenreEntity;
import com.z4greed.core.models.entity.MovieAudienceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MovieAudienceMapper {

    public MovieAudienceDto toDto(MovieAudienceEntity entity);
    public MovieAudienceEntity toEntity(MovieAudienceDto dto);
    @Mapping(target = "idMovieAudience", ignore = true)
    void updateEntityFromDto(MovieAudienceDto dto, @MappingTarget MovieAudienceEntity entity);

}