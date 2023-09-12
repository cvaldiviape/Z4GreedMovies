package com.z4greed.core.model.dto;

import lombok.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomDto {

    private Integer idRoom;
    private String code;
    private String location;
    private Integer seatingCapacity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomDto roomDto = (RoomDto) o;
        return Objects.equals(idRoom, roomDto.idRoom) && Objects.equals(code, roomDto.code) && Objects.equals(location, roomDto.location) && Objects.equals(seatingCapacity, roomDto.seatingCapacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRoom, code, location, seatingCapacity);
    }

}