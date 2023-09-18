package com.z4greed.core.models.common;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass // se utiliza para crear clases superiores que proporcionan atributos y comportamiento comunes a las clases descendientes, pero que no se mapean directamente a tablas en la base de datos.
public class BaseEntity {

    @Column(length = 3, nullable = false, unique = true)
    private String code;
    @Column(length = 40, nullable = false, unique = true)
    private String name;

}