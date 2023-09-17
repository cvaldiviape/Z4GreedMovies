package com.z4greed.core.model.mapper;

import com.shared.dto.RoomDto;
import com.z4greed.core.model.entity.RoomEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoomMapper {

    public RoomDto toDto(RoomEntity entity);
    public RoomEntity toEntity(RoomDto dto);

}