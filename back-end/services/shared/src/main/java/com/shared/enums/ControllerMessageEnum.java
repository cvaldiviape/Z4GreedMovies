package com.shared.enums;

public enum ControllerMessageEnum {

    GET_ALL("Getting list of items"),
    GET_BY_IO("item recovery by id"),
    CREATE("Successful creation"),
    UPDATE("Successful update"),
    DELETE("Successful elimination");

    private final String value;

    private ControllerMessageEnum(String value) {
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
