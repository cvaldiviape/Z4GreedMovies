package com.z4greed.core.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
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
    @Column(name = "id_room", nullable = false)
    private Integer idRoom;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SeatEntity that = (SeatEntity) o;
        return idSeat != null && Objects.equals(idSeat, that.idSeat);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}