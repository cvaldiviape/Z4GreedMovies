package com.facility.core.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "establishments")
public class EstablishmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_establishment")
    private Integer idEstablishment;
    @Column(length = 3, nullable = false, unique = true)
    private String code;
    @Column(length = 255, nullable = false)
    private String address;
    @Column(name = "id_district", nullable = false)
    private Integer idDistrict;
    @Builder.Default
    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "establishment")
    private Set<RoomEntity> listRooms = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstablishmentEntity that = (EstablishmentEntity) o;
        return Objects.equals(idEstablishment, that.idEstablishment) && Objects.equals(code, that.code) && Objects.equals(address, that.address) && Objects.equals(idDistrict, that.idDistrict) && Objects.equals(listRooms, that.listRooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstablishment, code, address, idDistrict, listRooms);
    }

}