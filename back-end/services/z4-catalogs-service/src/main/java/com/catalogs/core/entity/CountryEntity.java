package com.catalogs.core.entity;

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
@Table(name = "countries")
public class CountryEntity extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_country")
    private Integer idCountry;
    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
    private Set<StudioEntity> listStudies = new HashSet<>();

}