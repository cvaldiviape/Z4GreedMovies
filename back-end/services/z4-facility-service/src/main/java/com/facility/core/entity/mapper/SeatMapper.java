package com.facility.core.entity.mapper;

import com.shared.dto.external.facility.SeatDto;
import com.facility.core.entity.SeatEntity;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SeatMapper {

    @Named("SeatMapper.toDto")
    public SeatDto toDto(SeatEntity entity);
    @Named("SeatMapper.toEntity")
    public SeatEntity toEntity(SeatDto dto);
    @Named("SeatMapper.toListDtos")
    List<SeatDto> toListDtos(List<SeatEntity> listEntities);
    @Named("SeatMapper.toListEntities")
    List<SeatEntity> toListEntities(List<SeatDto> listDtos);
    @Named("SeatMapper.updateEntityFromDto")
    @Mappings({
            @Mapping(target = "idSeat", ignore = true),
            @Mapping(target = "room", ignore = true) // mejor que ingore el mapeo del "Room"
    })
    void updateEntityFromDto(SeatDto dto, @MappingTarget SeatEntity entity);

}