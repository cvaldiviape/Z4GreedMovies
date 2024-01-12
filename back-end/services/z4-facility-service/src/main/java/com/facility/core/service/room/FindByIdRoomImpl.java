package com.facility.core.service.room;

import com.facility.core.entity.RoomEntity;
import com.facility.core.entity.mapper.RoomMapperCustom;
import com.facility.core.repositories.RoomRespository;
import com.shared.core.service.impl.GenericFindByIdService;
import com.shared.dto.external.facility.RoomDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.stereotype.Service;

@Service("findByIdRoomImpl")
public class FindByIdRoomImpl extends GenericFindByIdService<RoomEntity, RoomDto, Integer> {

    private final RoomRespository roomRespository;
    private final RoomMapperCustom roomMapperCustom;

    public FindByIdRoomImpl(RoomRespository roomRespository, RoomMapperCustom roomMapperCustom) {
        this.roomRespository = roomRespository;
        this.roomMapperCustom = roomMapperCustom;
    }

    @Override
    public RoomDto toDto(RoomEntity roomEntity) {
        return this.roomMapperCustom.toDto(roomEntity);
    }

    @Override
    public RoomEntity findEntityById(Integer idRoom) {
        return this.roomRespository.findById(idRoom)
            .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.ROOM.getValue(), idRoom));
    }

}