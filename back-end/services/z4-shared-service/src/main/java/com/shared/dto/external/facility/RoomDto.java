package com.shared.dto.external.facility;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shared.utils.filter.Searchable;
import lombok.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomDto implements Searchable<Integer> {

    private Integer idRoom;
    private String code;
    private String location;
    private Integer seatingCapacity;
    private EstablishmentDto establishment;
    private Set<SeatDto> listSeats = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomDto roomDto = (RoomDto) o;
        return Objects.equals(idRoom, roomDto.idRoom) && Objects.equals(code, roomDto.code) && Objects.equals(location, roomDto.location) && Objects.equals(seatingCapacity, roomDto.seatingCapacity) && Objects.equals(establishment, roomDto.establishment) && Objects.equals(listSeats, roomDto.listSeats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRoom, code, location, seatingCapacity, establishment, listSeats);
    }

    @JsonIgnore
    @Override
    public Integer getSearcheableField() {
        return this.idRoom;
    }

}