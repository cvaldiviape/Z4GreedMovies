package com.facility.core.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_establishment")
    private EstablishmentEntity establishment;
    @Builder.Default
    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "room", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<SeatEntity> listSeats = new HashSet<>();

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