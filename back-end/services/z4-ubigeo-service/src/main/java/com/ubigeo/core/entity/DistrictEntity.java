package com.ubigeo.core.entity;

import com.shared.dto.custom.CommonEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "districts")
public class DistrictEntity extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_district")
    private Integer idDistrict;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_department")
    private DepartmentEntity department;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_province")
    private ProvinceEntity province;

}
