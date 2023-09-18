package com.z4greed.core.models.mapper;

import com.shared.dto.CountryDto;
import com.z4greed.core.models.entity.CountryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CountryMapper {

    public CountryDto toDto(CountryEntity entity);
    public CountryEntity toEntity(CountryDto dto);
    List<CountryDto> toListDtos(List<CountryEntity> listEntities);
    List<CountryEntity> toListEntities(List<CountryDto> listDtos);
    @Mapping(target = "idCountry", ignore = true)
    void updateEntityFromDto(CountryDto dto, @MappingTarget CountryEntity entity);

}