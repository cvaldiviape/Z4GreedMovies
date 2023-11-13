package com.catalogs.core.entity.mapper;

import com.shared.dto.CountryDto;
import com.catalogs.core.entity.CountryEntity;
import org.mapstruct.*;
import java.util.Collection;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CountryMapper {

    @Named("CountryMapper.toDto")
    public CountryDto toDto(CountryEntity entity);
    @Named("CountryMapper.toEntity")
    public CountryEntity toEntity(CountryDto dto);
    @Named("CountryMapper.toEntityIgnoredId")
    @Mapping(target = "idCountry", ignore = true)
    public CountryEntity toEntityIgnoredId(CountryDto dto);
    @Named("CountryMapper.toListDtos")
    Collection<CountryDto> toListDtos(Collection<CountryEntity> listEntities);
    @Named("CountryMapper.toListEntities")
    Collection<CountryEntity> toListEntities(Collection<CountryDto> listDtos);
    @Named("CountryMapper.updateEntityFromDto")
    void updateEntityFromDto(CountryDto dto, @MappingTarget CountryEntity entity);
    @Named("CountryMapper.updateEntityFromDtoIgnoredId")
    @Mapping(target = "idCountry", ignore = true)
    void updateEntityFromDtoIgnoredId(CountryDto dto, @MappingTarget CountryEntity entity);

}