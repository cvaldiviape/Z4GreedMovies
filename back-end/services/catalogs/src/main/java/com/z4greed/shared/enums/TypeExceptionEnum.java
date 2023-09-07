package com.z4greed.shared.enums;

public enum TypeExceptionEnum {

    INFO("I"), WARNING("W"), ERROR("E");

    private final String value;

    private TypeExceptionEnum(String value) {
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
