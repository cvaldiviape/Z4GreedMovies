package com.shared.enums;

public enum ValueEnum {
    NAME("nombre"),
    CODE("código"),
    CATEGORY("Categoria"),
    COUNTRY("Pais"),
    GENRE("Gémero"),
    LANGUAGE("Lenguaje"),
    AUDIENCE("Tipo de audiencia"),
    TYPE_STATUS_FILM_SHOW("Tipo de pelicula"),
    PRODUCT("Producto"),
    LIST_CATEGORY("Lista de categorias"),
    LIST_COUNTRY("Lista de paises"),
    LIST_GENRE("Lista de géneros"),
    LIST_LANGUAGE("Lista de lenguajes"),
    LIST_AUDIENCE("Lista de tipos de audiencias"),
    LIST_TYPE_STATUS_FILM_SHOW("Lista de tipos de peliculas"),
    LIST_PRODUCT("Lista de productos");

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
