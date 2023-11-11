package com.catalogs.core.entity.mapper;

import com.catalogs.core.entity.StudioEntity;
import com.shared.dto.StudioDto;
import org.mapstruct.*;

import java.util.Collection;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {CountryMapper.class})
public interface StudioMapper {

    public StudioDto toDto(StudioEntity entity);
    public StudioEntity toEntity(StudioDto dto);
    Collection<StudioDto> toListDtos(Collection<StudioEntity> listEntities);
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