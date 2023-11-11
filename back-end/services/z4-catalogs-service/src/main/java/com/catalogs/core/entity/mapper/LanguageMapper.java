package com.catalogs.core.entity.mapper;

import com.shared.dto.LanguageDto;
import com.catalogs.core.entity.LanguageEntity;
import org.mapstruct.*;
import java.util.Collection;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LanguageMapper {

    public LanguageDto toDto(LanguageEntity entity);
    public LanguageEntity toEntity(LanguageDto dto);
    Collection<LanguageDto> toListDtos(Collection<LanguageEntity> listEntities);
    Collection<LanguageEntity> toListEntities(Collection<LanguageDto> listDtos);
    @Named("LanguageMapper.updateEntityFromDto")
    void updateEntityFromDto(LanguageDto dto, @MappingTarget LanguageEntity entity);
    @Named("LanguageMapper.updateEntityFromDtoIgnoredId")
    @Mapping(target = "idLanguage", ignore = true)
    void updateEntityFromDtoIgnoredId(LanguageDto dto, @MappingTarget LanguageEntity entity);

}