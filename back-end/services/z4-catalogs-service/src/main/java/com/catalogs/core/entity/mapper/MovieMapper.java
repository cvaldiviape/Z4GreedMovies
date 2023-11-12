package com.catalogs.core.entity.mapper;

import com.catalogs.core.entity.MovieEntity;
import com.shared.dto.MovieDto;
import org.mapstruct.*;
import java.util.Collection;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {StudioMapper.class, MovieAudienceMapper.class, GenreMapper.class, LanguageMapper.class, ProfitAgreementsMapper.class})
public interface MovieMapper {

    @Named("MovieMapper.toDto")
    public MovieDto toDto(MovieEntity entity);
    @Named("MovieMapper.toEntity")
    public MovieEntity toEntity(MovieDto dto);
    @Named("MovieMapper.toEntityIgnoredId")
    @Mapping(target = "idMovie", ignore = true)
    public MovieEntity toEntityIgnoredId(MovieDto dto);
    @Named("MovieMapper.toListDtos")
    Collection<MovieDto> toListDtos(Collection<MovieEntity> listEntities);
    @Named("MovieMapper.toListEntities")
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