package com.facility.core.service.room;

import com.facility.core.entity.RoomEntity;
import com.facility.core.entity.mapper.RoomMapperCustom;
import com.facility.core.entity.mapper.RoomMapper;
import com.facility.core.repositories.RoomRespository;
import com.shared.core.service.impl.GenericUpdateService;
import com.shared.dto.external.facility.RoomDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("updateRoomImpl")
public class UpdateRoomImpl extends GenericUpdateService<RoomEntity, RoomDto, Integer> {

    private final RoomRespository roomRespository;
    private final RoomMapperCustom roomMapperCustom;
    private final RoomMapper roomMapper;

    public UpdateRoomImpl(RoomRespository roomRespository, RoomMapperCustom roomMapperCustom, RoomMapper roomMapper) {
        this.roomRespository = roomRespository;
        this.roomMapperCustom = roomMapperCustom;
        this.roomMapper = roomMapper;
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
    public void updateEntityFromDto(RoomDto roomDto, RoomEntity roomEntity) {
        this.roomMapper.updateEntityFromDtoIgnoredId(roomDto, roomEntity);
    }

    @Override
    public RoomEntity findEntityById(Integer idRoom) {
        return this.roomRespository.findById(idRoom)
            .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.ROOM.getValue(), idRoom));
    }

    @Override
    public void verifyUnique(Integer idRoom, RoomDto roomDto) {
        Boolean existsCode = this.roomRespository.existsByCodeAndIdRoomNot(roomDto.getCode(), idRoom);
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, roomDto.getCode());
    }

}