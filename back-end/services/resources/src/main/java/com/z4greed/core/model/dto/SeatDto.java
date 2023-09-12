package com.z4greed.core.model.dto;

import lombok.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatDto {

    private Integer idSeat;
    private String code;
    private Integer idRoom;
    private RoomDto room;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeatDto seatDto = (SeatDto) o;
        return Objects.equals(idSeat, seatDto.idSeat) && Objects.equals(code, seatDto.code) && Objects.equals(idRoom, seatDto.idRoom) && Objects.equals(room, seatDto.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSeat, code, idRoom, room);
    }

}