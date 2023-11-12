package com.catalogs.core.entity.mapper;

import com.shared.dto.TypeStatusFilmShowDto;
import com.catalogs.core.entity.TypeStatusFilmShowEntity;
import org.mapstruct.*;

import java.util.Collection;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TypeStatusFilmShowMapper {

    @Named("TypeStatusFilmShowMapper.toDto")
    public TypeStatusFilmShowDto toDto(TypeStatusFilmShowEntity entity);
    @Named("TypeStatusFilmShowMapper.toEntity")
    public TypeStatusFilmShowEntity toEntity(TypeStatusFilmShowDto dto);
    @Named("TypeStatusFilmShowMapper.toEntityIgnoredId")
    @Mapping(target = "idTypeStatusFilmShow", ignore = true)
    public TypeStatusFilmShowEntity toEntityIgnoredId(TypeStatusFilmShowDto dto);
    @Named("TypeStatusFilmShowMapper.toListDtos")
    Collection<TypeStatusFilmShowDto> toListDtos(Collection<TypeStatusFilmShowEntity> listEntities);
    @Named("TypeStatusFilmShowMapper.toListEntities")
    Collection<TypeStatusFilmShowEntity> toListEntities(Collection<TypeStatusFilmShowDto> listDtos);
    @Named("TypeStatusFilmShowMapper.updateEntityFromDto")
    void updateEntityFromDto(TypeStatusFilmShowDto dto, @MappingTarget TypeStatusFilmShowEntity entity);
    @Named("TypeStatusFilmShowMapper.updateEntityFromDtoIgnoredId")
    @Mapping(target = "idTypeStatusFilmShow", ignore = true)
    void updateEntityFromDtoIgnoredId(TypeStatusFilmShowDto dto, @MappingTarget TypeStatusFilmShowEntity entity);

}