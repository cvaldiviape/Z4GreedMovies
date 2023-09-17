package com.z4greed.core.enums;

import lombok.Getter;

@Getter
public enum ProductValueEnum {
    PRODUCT("Producto"),
    CATEGORY("Categoria"),
    LIST_CATEGORY("Lista de categorias");

    private final String value;

    private ProductValueEnum(String value) {
        this.value = value;
    }

}