package com.z4greed.core.models.mapper;

import com.z4greed.core.models.dto.LanguageDto;
import com.z4greed.core.models.entity.LanguageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface LanguageMapper {

    public LanguageDto toDto(LanguageEntity entity);
    public LanguageEntity toEntity(LanguageDto dto);
    @Mapping(target = "idLanguage", ignore = true)
    void updateEntityFromDto(LanguageDto dto, @MappingTarget LanguageEntity entity);

}