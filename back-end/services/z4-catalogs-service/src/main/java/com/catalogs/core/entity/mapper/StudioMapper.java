package com.catalogs.core.entity.mapper;

import com.catalogs.core.entity.StudioEntity;
import com.shared.dto.external.catalogs.StudioDto;
import org.mapstruct.*;

import java.util.Collection;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {CountryMapper.class})
public interface StudioMapper {

    @Named("StudioMapper.toDto")
    public StudioDto toDto(StudioEntity entity);
    @Named("StudioMapper.toEntity")
    public StudioEntity toEntity(StudioDto dto);
    @Named("StudioMapper.toEntityIgnoredId")
    @Mapping(target = "idStudio", ignore = true)
    public StudioEntity toEntityIgnoredId(StudioDto dto);
    @Named("StudioMapper.toListDtos")
    Collection<StudioDto> toListDtos(Collection<StudioEntity> listEntities);
    @Named("StudioMapper.updateEntityFromDto")
    Collection<StudioEntity> toListEntities(Collection<StudioDto> listDtos);
    @Named("StudioMapper.updateEntityFromDto")
    @Mappings({
            @Mapping(target = "country", qualifiedByName = "CountryMapper.updateEntityFromDto"),
    })
    void updateEntityFromDto(StudioDto dto, @MappingTarget StudioEntity entity);
    @Named("StudioMapper.updateEntityFromDtoIgnoredId")
    @Mappings({
            @Mapping(target = "idStudio", ignore = true),
            @Mapping(target = "country", qualifiedByName = "CountryMapper.updateEntityFromDto"),
    })
    void updateEntityFromDtoIgnoredId(StudioDto dto, @MappingTarget StudioEntity entity);

}