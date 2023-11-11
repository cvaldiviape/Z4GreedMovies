package com.shared.enums;

public enum ValueEnum {
    NAME("nombre"),
    CODE("código"),
    DESCRIPTION("descripción"),
    CATEGORY("Categoria"),
    COUNTRY("Pais"),
    GENRE("Gémero"),
    LANGUAGE("Lenguaje"),
    AUDIENCE("Tipo de audiencia"),
    TYPE_STATUS_FILM_SHOW("Tipo de pelicula"),
    PRODUCT("Producto"),
    ROOM("Sala"),
    SEAT("Asiento"),
    DEPARTMENT("Departamento"),
    DISTRICT("Distrito"),
    PROVINCE("Province"),
    STUDIO("Estudio"),
    MOVIE("Pelicula"),
    LIST_CATEGORY("Lista de categorias"),
    LIST_COUNTRY("Lista de paises"),
    LIST_GENRE("Lista de géneros"),
    LIST_LANGUAGE("Lista de lenguajes"),
    LIST_AUDIENCE("Lista de tipos de audiencias"),
    LIST_TYPE_STATUS_FILM_SHOW("Lista de tipos de peliculas"),
    LIST_PRODUCT("Lista de productos"),
    LIST_ROOM("Lista de salsa"),
    LIST_SEAT("Lista de asientos"),
    LIST_DEPARTMENT("Lista de departamentos"),
    LIST_DISTRICT("Lista de distritos"),
    LIST_PROVINCE("Lista de provincias"),
    LIST_STUDIO("Lista de estudios"),
    LIST_MOVIE("Lista de peliculas");

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
