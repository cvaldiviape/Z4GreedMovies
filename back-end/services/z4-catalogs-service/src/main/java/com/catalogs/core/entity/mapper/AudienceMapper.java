package com.catalogs.core.entity.mapper;

import com.catalogs.core.entity.AudienceEntity;
import com.shared.dto.AudienceDto;
import org.mapstruct.*;
import java.util.Collection;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AudienceMapper {

    @Named("AudienceMapper.toDto")
    public AudienceDto toDto(AudienceEntity entity);
    @Named("AudienceMapper.toEntity")
    public AudienceEntity toEntity(AudienceDto dto);
    @Named("AudienceMapper.toEntityIgnoredId")
    @Mapping(target = "idAudience", ignore = true)
    public AudienceEntity toEntityIgnoredId(AudienceDto dto);
    @Named("AudienceMapper.toListDtos")
    Collection<AudienceDto> toListDtos(Collection<AudienceEntity> listEntities);
    @Named("AudienceMapper.toListEntities")
    Collection<AudienceEntity> toListEntities(Collection<AudienceDto> listDtos);
    @Named("AudienceMapper.updateEntityFromDto")
    void updateEntityFromDto(AudienceDto dto, @MappingTarget AudienceEntity entity);
    @Named("AudienceMapper.updateEntityFromDtoIgnoredId")
    @Mapping(target = "idAudience", ignore = true)
    void updateEntityFromDtoIgnoredId(AudienceDto dto, @MappingTarget AudienceEntity entity);

}