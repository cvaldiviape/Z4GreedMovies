package com.z4greed.enums;

import lombok.Getter;

@Getter
public enum CategoryProductValueEnum {
    CATEGORIA("Categoria");

    private final String value;

    private CategoryProductValueEnum(String value) {
        this.value = value;
    }

}