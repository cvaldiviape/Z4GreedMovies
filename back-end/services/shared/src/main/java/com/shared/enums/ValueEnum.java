package com.shared.enums;

public enum ValueEnum {
    NAME("nombre"),
    CODE("código"),
    CATEGORY("Categoria"),
    COUNTRY("Pais"),
    GENRE("Gémero"),
    LANGUAGE("Lenguaje"),
    AUDIENCE("Audencia"),
    TYPE_STATUS_FILM_SHOW("Tipo de pelicula");

    private final String value;

    private ValueEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public String getValue() {
        return value;
    }

}
