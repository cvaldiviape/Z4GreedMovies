package com.shared.error;

import com.shared.enums.TypeExceptionEnum;

public interface GenericError {

    String getCode();

    String getMessage();

    TypeExceptionEnum getType();

}