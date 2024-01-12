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
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "room", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH}, orphanRemoval = true)
    private Set<SeatEntity> listSeats = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomEntity that = (RoomEntity) o;
        return Objects.equals(idRoom, that.idRoom) && Objects.equals(code, that.code) && Objects.equals(location, that.location) && Objects.equals(seatingCapacity, that.seatingCapacity) && Objects.equals(establishment, that.establishment) && Objects.equals(listSeats, that.listSeats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRoom, code, location, seatingCapacity, establishment, listSeats);
    }

}