package com.z4greed.core.entity.mapper;

import com.shared.dto.LanguageDto;
import com.z4greed.core.entity.LanguageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LanguageMapper {

    public LanguageDto toDto(LanguageEntity entity);
    public LanguageEntity toEntity(LanguageDto dto);
    List<LanguageDto> toListDtos(List<LanguageEntity> listEntities);
    List<LanguageEntity> toListEntities(List<LanguageDto> listDtos);
    @Mapping(target = "idLanguage", ignore = true)
    void updateEntityFromDto(LanguageDto dto, @MappingTarget LanguageEntity entity);

}