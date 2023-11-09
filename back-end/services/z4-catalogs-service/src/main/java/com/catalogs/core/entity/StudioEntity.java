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
@Table(name = "studies")
public class StudioEntity extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_studio")
    private Integer idStudio;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_country")
    private CountryEntity country;
    @Builder.Default
    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "studio")
    private Set<MovieEntity> listMovies = new HashSet<>();

}