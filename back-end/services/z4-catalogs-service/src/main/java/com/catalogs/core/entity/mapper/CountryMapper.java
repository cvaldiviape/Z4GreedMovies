package com.catalogs.core.entity.mapper;

import com.shared.dto.CountryDto;
import com.catalogs.core.entity.CountryEntity;
import org.mapstruct.*;

import java.util.Collection;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CountryMapper {

    public CountryDto toDto(CountryEntity entity);
    public CountryEntity toEntity(CountryDto dto);
    Collection<CountryDto> toListDtos(Collection<CountryEntity> listEntities);
    Collection<CountryEntity> toListEntities(Collection<CountryDto> listDtos);
    @Named("CountryMapper.updateEntityFromDto")
    void updateEntityFromDto(CountryDto dto, @MappingTarget CountryEntity entity);
    @Named("CountryMapper.updateEntityFromDtoIgnoredId")
    @Mapping(target = "idCountry", ignore = true)
    void updateEntityFromDtoIgnoredId(CountryDto dto, @MappingTarget CountryEntity entity);

}