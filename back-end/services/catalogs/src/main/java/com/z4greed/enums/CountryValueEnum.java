package com.z4greed.enums;

import lombok.Getter;

@Getter
public enum CountryValueEnum {
    PAIS("Pais");

    private final String value;

    private CountryValueEnum(String value) {
        this.value = value;
    }

}