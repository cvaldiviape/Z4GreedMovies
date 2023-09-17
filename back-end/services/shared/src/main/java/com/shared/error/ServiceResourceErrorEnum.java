package com.shared.error;

import static com.shared.error.TypeExceptionEnum.WARNING;

public enum ServiceResourceErrorEnum implements GenericError {
    E0000("E0000", "", WARNING);

    private final String code;
    private final String message;
    private final TypeExceptionEnum type;

    private ServiceResourceErrorEnum(String code, String message, TypeExceptionEnum type) {
        this.code = code;
        this.message = message;
        this.type = type;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public TypeExceptionEnum getType() {
        return this.type;
    }

}