package com.facility.core.entity.mapper;

import com.shared.dto.SeatDto;
import com.facility.core.entity.SeatEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {RoomMapper.class}) // como "Seat" contiene "Room", hago que use el RoomMapper, aunque cabe aclarar
                                                                                            // que "MapStruct" tambien se encarga de hacer el mapeo aparte, pero mejor es indicarle
                                                                                            // que use el "RoomMapper" que yo he creado, ya que tengo cosas mas personalizadas.
public interface SeatMapper {

    public SeatDto toDto(SeatEntity entity);
    public SeatEntity toEntity(SeatDto dto);
    List<SeatDto> toListDtos(List<SeatEntity> listEntities);
    List<SeatEntity> toListEntities(List<SeatDto> listDtos);
    @Mappings({
            @Mapping(target = "idSeat", ignore = true),
            @Mapping(target = "room", ignore = true) // mejor que ingore el mapeo del "Room"
    })
    void updateEntityFromDto(SeatDto dto, @MappingTarget SeatEntity entity);

}