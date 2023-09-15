package com.shared.enums;

import com.shared.enums.TypeExceptionEnum;
import com.shared.error.GenericError;

import static com.shared.enums.TypeExceptionEnum.WARNING;

public enum ServiceResourceErrorEnum implements GenericError {
    SRE_E000001("SRE_E000001", "%s no existe!", WARNING);

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