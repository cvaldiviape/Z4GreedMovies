package com.z4greed.core.models.entity.base;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass // se utiliza para crear clases superiores que proporcionan atributos y comportamiento comunes a las clases descendientes, pero que no se mapean directamente a tablas en la base de datos.
public class BaseEntity {

    @Column(name = "code", nullable = false, unique = true)
    private String code;
    @Column(name = "name", nullable = false, unique = true)
    private String name;

}