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
@Table(name = "rooms")
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_room")
    private Integer idRoom;
    @Column(length = 3, nullable = false, unique = true)
    private String code;
    @Column(length = 50, nullable = false)
    private String location;
    @Column(name = "seating_capacity", nullable = false)
    private Integer seatingCapacity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RoomEntity that = (RoomEntity) o;
        return idRoom != null && Objects.equals(idRoom, that.idRoom);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}