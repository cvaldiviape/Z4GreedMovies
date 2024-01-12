package com.facility.core.entity.mapper;

import com.shared.dto.external.facility.SeatDto;
import com.facility.core.entity.SeatEntity;
import org.mapstruct.*;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {RoomMapper.class})
public interface SeatMapper {

    @Named("SeatMapper.toDto")
    SeatDto toDto(SeatEntity entity);
    @Named("SeatMapper.toDtoIgnoredRoom")
    @Mapping(target = "room", qualifiedByName = "RoomMapper.toDtoIgnoredListSeats")
    SeatDto toDtoIgnoredRoom(SeatEntity entity);
    @Named("SeatMapper.toEntity")
    SeatEntity toEntity(SeatDto dto);
    @Named("SeatMapper.toEntityIgnoredRoom")
    @Mapping(target = "room", qualifiedByName = "RoomMapper.toEntityIgnoredListSeats")
    SeatEntity toEntityIgnoredRoom(SeatDto dto);
    @Named("SeatMapper.toListDtos")
    List<SeatDto> toListDtos(List<SeatEntity> listEntities);
    @Named("SeatMapper.toListDtosIgnoredRoom")
    @IterableMapping(qualifiedByName = "SeatMapper.toDtoIgnoredRoom")
    Set<SeatDto> toListDtosIgnoredRoom(Set<SeatEntity> listEntities);
    @Named("SeatMapper.toListEntities")
    List<SeatEntity> toListEntities(List<SeatDto> listDtos);
    @Named("SeatMapper.toListEntitiesIgnoredRoom")
    @IterableMapping(qualifiedByName = "SeatMapper.toEntityIgnoredRoom")
    Set<SeatEntity> toListEntitiesIgnoredRoom(Set<SeatDto> listDtos);
    @Named("SeatMapper.updateEntityFromDto")
    @Mappings({
            @Mapping(target = "idSeat", ignore = true),
            @Mapping(target = "room", ignore = true) // mejor que ingore el mapeo del "Room"
    })
    void updateEntityFromDto(SeatDto dto, @MappingTarget SeatEntity entity);

}