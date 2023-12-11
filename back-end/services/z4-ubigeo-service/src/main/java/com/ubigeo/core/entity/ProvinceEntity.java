package com.ubigeo.core.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.shared.dto.custom.CommonEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "provinces")
public class ProvinceEntity extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_province")
    private Integer idProvince;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_department")
    private DepartmentEntity department;
    @Builder.Default
    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "province")
    private Set<DistrictEntity> listDistricts = new HashSet<>();

}