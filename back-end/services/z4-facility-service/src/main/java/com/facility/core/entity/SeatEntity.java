package com.facility.core.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "seats")
public class SeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_seat")
    private Integer idSeat;
    @Column(length = 3, nullable = false, unique = true)
    private String code;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_room")
    private RoomEntity room;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeatEntity that = (SeatEntity) o;
        return Objects.equals(idSeat, that.idSeat) && Objects.equals(code, that.code) && Objects.equals(room, that.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSeat, code, room);
    }

}