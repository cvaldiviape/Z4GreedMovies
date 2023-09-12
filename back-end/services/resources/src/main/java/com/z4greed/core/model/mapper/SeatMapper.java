package com.z4greed.core.model.mapper;

import com.z4greed.core.model.dto.SeatDto;
import com.z4greed.core.model.entity.SeatEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SeatMapper {

    public SeatDto toDto(SeatEntity entity);
    public SeatEntity toEntity(SeatDto dto);

}