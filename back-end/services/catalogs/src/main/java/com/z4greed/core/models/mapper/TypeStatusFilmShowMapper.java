package com.z4greed.core.models.mapper;

import com.shared.dto.TypeStatusFilmShowDto;
import com.z4greed.core.models.entity.TypeStatusFilmShowEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TypeStatusFilmShowMapper {

    public TypeStatusFilmShowDto toDto(TypeStatusFilmShowEntity entity);
    public TypeStatusFilmShowEntity toEntity(TypeStatusFilmShowDto dto);
    List<TypeStatusFilmShowDto> toListDtos(List<TypeStatusFilmShowEntity> listEntities);
    List<TypeStatusFilmShowEntity> toListEntities(List<TypeStatusFilmShowDto> listDtos);
    @Mapping(target = "idTypeStatusFilmShow", ignore = true)
    void updateEntityFromDto(TypeStatusFilmShowDto dto, @MappingTarget TypeStatusFilmShowEntity entity);

}