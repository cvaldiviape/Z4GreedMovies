package com.catalogs.core.entity.mapper;

import com.shared.dto.TypeStatusFilmShowDto;
import com.catalogs.core.entity.TypeStatusFilmShowEntity;
import org.mapstruct.*;

import java.util.Collection;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TypeStatusFilmShowMapper {

    public TypeStatusFilmShowDto toDto(TypeStatusFilmShowEntity entity);
    public TypeStatusFilmShowEntity toEntity(TypeStatusFilmShowDto dto);
    Collection<TypeStatusFilmShowDto> toListDtos(Collection<TypeStatusFilmShowEntity> listEntities);
    Collection<TypeStatusFilmShowEntity> toListEntities(Collection<TypeStatusFilmShowDto> listDtos);
    @Named("TypeStatusFilmShowMapper.updateEntityFromDto")
    void updateEntityFromDto(TypeStatusFilmShowDto dto, @MappingTarget TypeStatusFilmShowEntity entity);
    @Named("TypeStatusFilmShowMapper.updateEntityFromDtoIgnoredId")
    @Mapping(target = "idTypeStatusFilmShow", ignore = true)
    void updateEntityFromDtoIgnoredId(TypeStatusFilmShowDto dto, @MappingTarget TypeStatusFilmShowEntity entity);

}