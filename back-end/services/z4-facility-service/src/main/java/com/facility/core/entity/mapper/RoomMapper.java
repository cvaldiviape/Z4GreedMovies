package com.facility.core.entity.mapper;

import com.shared.dto.external.facility.RoomDto;
import com.facility.core.entity.RoomEntity;
import org.mapstruct.*;
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