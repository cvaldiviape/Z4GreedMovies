package com.facility.core.service.room;

import com.facility.core.entity.RoomEntity;
import com.facility.core.entity.mapper.RoomMapperCustom;
import com.facility.core.repositories.RoomRespository;
import com.shared.core.service.CreateService;
import com.shared.dto.external.facility.RoomDto;
import com.shared.dto.external.facility.SeatDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service("createRoomImpl")
public class CrearteRoomImpl implements CreateService<RoomDto> {

    private final RoomRespository roomRespository;
    private final RoomMapperCustom roomMapperCustom;

    public CrearteRoomImpl(RoomRespository roomRespository, RoomMapperCustom roomMapperCustom) {
        this.roomRespository = roomRespository;
        this.roomMapperCustom = roomMapperCustom;
    }

    @Override
    public RoomDto create(RoomDto roomDto) {
        this.validateUniqueFields(roomDto);
        this.setComplementaryData(roomDto);
        RoomEntity roomEntity = this.roomMapperCustom.toEntityIgnoredId(roomDto);
        RoomEntity roomCreated = this.roomRespository.save(roomEntity);
        return this.roomMapperCustom.toDto(roomCreated);
    }

    public void validateUniqueFields(RoomDto roomDto) {
        Boolean existsCode = this.roomRespository.existsByCode(roomDto.getCode());
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, roomDto.getCode());
    }

    private void setComplementaryData(RoomDto roomDto) { // TODO: PRIMERO CREAR EL ROOM SOLO, Y DESPUES CREAR LOS SEATS APUNTANDO AL ROOM RECIEN CREADO
        Set<SeatDto> listSeats = buildListSeats(roomDto);
        for (SeatDto seat: listSeats) {
            seat.setRoom(roomDto);
        }
        roomDto.setListSeats(listSeats);
    }

    private Set<SeatDto> buildListSeats(RoomDto roomDto) {
        String codeRoom = roomDto.getCode();
        Integer capacity = roomDto.getSeatingCapacity();

        Set<SeatDto> listSeats = new HashSet<>();
        for (int i = 1; i <= capacity; i++) {
            SeatDto seatDto = buildSeat(i, codeRoom);
            listSeats.add(seatDto);
        }
        return listSeats;
    }

    private SeatDto buildSeat(int i, String codeRoom) {
        String codeSeat = buildCodeSeat(i, codeRoom);
        return SeatDto.builder()
            .code(codeSeat)
            .build();
    }

    private String buildCodeSeat(int i, String codeRoom) {
        String code = String.format("%03d", i);
        return codeRoom.concat("-").concat(code);
    }

}