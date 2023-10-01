package com.z4greed.core.entity.mapper;

import com.shared.dto.RoomDto;
import com.z4greed.core.entity.RoomEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoomMapper {

    public RoomDto toDto(RoomEntity entity);
    public RoomEntity toEntity(RoomDto dto);
    List<RoomDto> toListDtos(List<RoomEntity> listEntities);
    List<RoomEntity> toListEntities(List<RoomDto> listDtos);
    @Mapping(target = "idRoom", ignore = true)
    void updateEntityFromDto(RoomDto dto, @MappingTarget RoomEntity entity);

}