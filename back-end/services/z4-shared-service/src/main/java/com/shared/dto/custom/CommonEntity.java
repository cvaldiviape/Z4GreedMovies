package com.shared.dto.custom;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass // se utiliza para crear clases superiores que proporcionan atributos y comportamiento comunes a las clases descendientes, pero que no se mapean directamente a tablas en la base de datos.
public class CommonEntity {

    @Column(length = 3, nullable = false, unique = true)
    private String code;
    @Column(length = 40, nullable = false, unique = true)
    private String name;

}