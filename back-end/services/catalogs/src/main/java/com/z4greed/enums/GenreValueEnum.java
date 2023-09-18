package com.z4greed.enums;

import lombok.Getter;

@Getter
public enum GenreValueEnum {
    GENERO("Género");

    private final String value;

    private GenreValueEnum(String value) {
        this.value = value;
    }

}