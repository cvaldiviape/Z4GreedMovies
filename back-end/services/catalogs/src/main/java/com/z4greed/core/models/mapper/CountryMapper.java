package com.z4greed.core.models.mapper;

import com.z4greed.core.models.dto.CategoryProductDto;
import com.z4greed.core.models.dto.CountryDto;
import com.z4greed.core.models.entity.CategoryProductEntity;
import com.z4greed.core.models.entity.CountryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    public CountryDto toDto(CountryEntity entity);
    public CountryEntity toEntity(CountryDto dto);
    @Mapping(target = "idCountry", ignore = true)
    void updateEntityFromDto(CountryDto dto, @MappingTarget CountryEntity entity);

}
