package com.z4greed.core.models.mapper;

import com.z4greed.core.models.dto.TypeStatusFilmShowDto;
import com.z4greed.core.models.entity.TypeStatusFilmShowEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TypeStatusFilmShowMapper {

    public TypeStatusFilmShowDto toDto(TypeStatusFilmShowEntity entity);
    public TypeStatusFilmShowEntity toEntity(TypeStatusFilmShowDto dto);
    @Mapping(target = "idTypeStatusFilmShow", ignore = true)
    void updateEntityFromDto(TypeStatusFilmShowDto dto, @MappingTarget TypeStatusFilmShowEntity entity);

}