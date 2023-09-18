package com.z4greed.enums;

import lombok.Getter;

@Getter
public enum MovieAudienceValueEnum {
    AUDIENCIA("Audiencia");

    private final String value;

    private MovieAudienceValueEnum(String value) {
        this.value = value;
    }

}