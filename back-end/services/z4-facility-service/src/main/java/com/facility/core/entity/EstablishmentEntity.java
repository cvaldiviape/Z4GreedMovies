package com.facility.core.entity;

import jakarta.persistence.*;
import lombok.*;

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
    @Column(length = 255, nullable = false, unique = true)
    private String code;
    @Column(name = "idDistrict", nullable = false)
    private Integer idDistrict;

}