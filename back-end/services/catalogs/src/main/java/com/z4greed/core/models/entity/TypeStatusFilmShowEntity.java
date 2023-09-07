package com.z4greed.core.models.entity;

import com.z4greed.core.models.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "type_status_film_shows")
public class TypeStatusFilmShowEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_status_film_show")
    private Integer idTypeStatusFilmShow;

}