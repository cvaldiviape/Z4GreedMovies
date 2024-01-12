package com.facility.core.service.room;

import com.facility.core.entity.RoomEntity;
import com.facility.core.entity.mapper.RoomMapperCustom;
import com.facility.core.repositories.RoomRespository;
import com.shared.core.service.impl.GenericDeleteService;
import com.shared.dto.external.facility.RoomDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("deleteRoomImpl")
public class DeleteRoomImpl extends GenericDeleteService<RoomEntity, RoomDto, Integer> {

    private final RoomRespository roomRespository;
    private final RoomMapperCustom roomMapperCustom;

    public DeleteRoomImpl(RoomRespository roomRespository, RoomMapperCustom roomMapperCustom) {
        this.roomRespository = roomRespository;
        this.roomMapperCustom = roomMapperCustom;
    }

    @Override
    public JpaRepository<RoomEntity, Integer> getJpaRepository() {
        return this.roomRespository;
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