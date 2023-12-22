package com.facility.core.entity.mapper;

import com.shared.dto.external.facility.RoomDto;
import com.facility.core.entity.RoomEntity;
import org.mapstruct.*;
import java.util.Collection;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {SeatMapper.class})
public interface RoomMapper {

    @Named("RoomMapper.toDto")
    RoomDto toDto(RoomEntity entity);
    @Named("RoomMapper.toEntity")
    RoomEntity toEntity(RoomDto dto);
    @Mapping(target = "idRoom", ignore = true)
    @Named("RoomMapper.toEntityIgnoredId")
    RoomEntity toEntityIgnoredId(RoomDto dto);
    @Named("RoomMapper.toListDtos")
    Collection<RoomDto> toListDtos(Collection<RoomEntity> listEntities);
    @Named("RoomMapper.toListEntities")
    Collection<RoomEntity> toListEntities(Collection<RoomDto> listDtos);
    @Named("RoomMapper.updateEntityFromDtoIgnoredId")
    @Mapping(target = "idRoom", ignore = true)
    void updateEntityFromDtoIgnoredId(RoomDto dto, @MappingTarget RoomEntity entity);

}