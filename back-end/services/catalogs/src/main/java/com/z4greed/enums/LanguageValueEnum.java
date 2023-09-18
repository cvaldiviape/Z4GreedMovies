package com.z4greed.enums;

import lombok.Getter;

@Getter
public enum LanguageValueEnum {
    LENGUAJE("Lenguaje");

    private final String value;

    private LanguageValueEnum(String value) {
        this.value = value;
    }

}