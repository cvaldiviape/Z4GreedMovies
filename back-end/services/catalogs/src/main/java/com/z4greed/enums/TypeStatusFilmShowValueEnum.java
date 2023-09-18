package com.z4greed.enums;

import lombok.Getter;

@Getter
public enum TypeStatusFilmShowValueEnum {
    TIPO_ESTADO_PELICULA("Tipo de pelicula");

    private final String value;

    private TypeStatusFilmShowValueEnum(String value) {
        this.value = value;
    }

}