package com.facility.core.entity.mapper;

import com.shared.dto.external.facility.RoomDto;
import com.facility.core.entity.RoomEntity;
import org.mapstruct.*;
import java.util.Collection;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoomMapper {

    @Named("RoomMapper.toDtoIgnoredListSeats")
    @Mapping(target = "listSeats", ignore = true)
    RoomDto toDtoIgnoredListSeats(RoomEntity entity);
    @Named("RoomMapper.toEntity")
    RoomEntity toEntity(RoomDto dto);
    @Named("RoomMapper.toEntityIgnoredListSeats")
    @Mapping(target = "listSeats", ignore = true)
    RoomEntity toEntityIgnoredListSeats(RoomDto dto);
    @Named("RoomMapper.toListDtos")
    Collection<RoomDto> toListDtos(Collection<RoomEntity> listEntities);
    @Named("RoomMapper.toListEntities")
    Collection<RoomEntity> toListEntities(Collection<RoomDto> listDtos);
    @Named("RoomMapper.updateEntityFromDtoIgnoredId")
    @Mapping(target = "idRoom", ignore = true)
    void updateEntityFromDtoIgnoredId(RoomDto dto, @MappingTarget RoomEntity entity);

}