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
@Table(name = "departments")
public class DepartmentEntity extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_department")
    private Integer idDepartment;
    @Builder.Default
    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<ProvinceEntity> listProvinces = new HashSet<>();
    @Builder.Default
    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<DistrictEntity> listDistricts = new HashSet<>();

}