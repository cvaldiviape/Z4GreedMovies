package com.catalogs.core.entity.mapper;

import com.catalogs.core.entity.MovieEntity;
import com.shared.dto.MovieDto;
import org.mapstruct.*;

import java.util.Collection;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {StudioMapper.class, MovieAudienceMapper.class, GenreMapper.class, LanguageMapper.class, ProfitAgreementsMapper.class})
public interface MovieMapper {

    public MovieDto toDto(MovieEntity entity);
    public MovieEntity toEntity(MovieDto dto);
    Collection<MovieDto> toListDtos(Collection<MovieEntity> listEntities);
    Collection<MovieEntity> toListEntities(Collection<MovieDto> listDtos);
    @Named("MovieMapper.updateEntityFromDto")
    @Mappings({
            @Mapping(target = "studio", qualifiedByName = "StudioMapper.updateEntityFromDto"),
            @Mapping(target = "movieAudience", qualifiedByName = "MovieAudienceMapper.updateEntityFromDto"),
            @Mapping(target = "profitAgreements", qualifiedByName = "ProfitAgreementsMapper.updateEntityFromDto")
    })
    void updateEntityFromDto(MovieDto dto, @MappingTarget MovieEntity entity);
    @Named("MovieMapper.updateEntityFromDtoIgnoredId")
    @Mappings({
            @Mapping(target = "idMovie", ignore = true),
            @Mapping(target = "studio", qualifiedByName = "StudioMapper.updateEntityFromDto"),
            @Mapping(target = "movieAudience", qualifiedByName = "MovieAudienceMapper.updateEntityFromDto"),
            @Mapping(target = "profitAgreements", qualifiedByName = "ProfitAgreementsMapper.updateEntityFromDto")
    })
    void updateEntityFromDtoIgnoredId(MovieDto dto, @MappingTarget MovieEntity entity);

}