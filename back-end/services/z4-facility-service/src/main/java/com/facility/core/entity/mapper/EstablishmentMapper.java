package com.facility.core.entity.mapper;

import com.facility.core.entity.EstablishmentEntity;
import com.shared.dto.external.facility.EstablishmentDto;
import org.mapstruct.*;
import java.util.Collection;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EstablishmentMapper {

    @Named("EstablishmentMapper.toDto")
    EstablishmentDto toDto(EstablishmentEntity entity);
    @Named("EstablishmentMapper.toEntity")
    EstablishmentEntity toEntity(EstablishmentDto dto);
    @Named("EstablishmentMapper.toDto")
    @Mapping(target = "idEstablishment", ignore = true)
    EstablishmentEntity toEntityIgnoredId(EstablishmentDto dto);
    @Named("EstablishmentMapper.toListDtos")
    Collection<EstablishmentDto> toListDtos(Collection<EstablishmentEntity> listEntities);
    @Named("EstablishmentMapper.toListEntities")
    Collection<EstablishmentEntity> toListEntities(Collection<EstablishmentDto> listDtos);
    @Named("EstablishmentMapper.updateEntityFromDto")
    @Mapping(target = "idEstablishment", ignore = true)
    void updateEntityFromDtoIgnoredId(EstablishmentDto dto, @MappingTarget EstablishmentEntity entity);

}