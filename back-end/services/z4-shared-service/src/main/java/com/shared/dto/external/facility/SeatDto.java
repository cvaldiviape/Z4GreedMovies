package com.shared.dto.external.facility;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shared.utils.filter.Searchable;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatDto implements Searchable<Integer> {

    private Integer idSeat;
    private String code;
    private RoomDto room;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeatDto seatDto = (SeatDto) o;
        return Objects.equals(idSeat, seatDto.idSeat) && Objects.equals(code, seatDto.code) && Objects.equals(room, seatDto.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSeat, code, room);
    }

    @JsonIgnore
    @Override
    public Integer getSearcheableField() {
        return this.idSeat;
    }

}