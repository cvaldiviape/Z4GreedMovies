package com.facility.core.entity.mapper;

import com.facility.core.entity.RoomEntity;
import com.shared.dto.external.facility.RoomDto;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {RoomMapper.class, SeatMapper.class})
public interface RoomMapperCustom {

    @Named("RoomMapper.toDto")
    @Mapping(target = "listSeats", qualifiedByName = "SeatMapper.toListDtosIgnoredRoom")
    RoomDto toDto(RoomEntity entity);
    @Named("RoomMapperCustom.toEntityIgnoredId")
    @Mappings({
        @Mapping(target = "idRoom", ignore = true),
        @Mapping(target = "listSeats", qualifiedByName = "SeatMapper.toListEntitiesIgnoredRoom")
    })
    RoomEntity toEntityIgnoredId(RoomDto dto);

}