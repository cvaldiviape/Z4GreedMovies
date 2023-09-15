package com.shared.utils;

import com.shared.dto.custom.ResponseDto;
import com.shared.enums.ControllerMessageEnum;
import com.shared.enums.TypeExceptionEnum;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ResponseUtil {

    public static ResponseDto ok(ControllerMessageEnum messageEnum, Object data) {
        return load(true, messageEnum, data, HttpStatus.OK, null);
    }

    public static ResponseDto error(ControllerMessageEnum messageEnum, Object data) {
        return load(true, messageEnum, data, HttpStatus.BAD_REQUEST, TypeExceptionEnum.ERROR);
    }

    public static ResponseDto error(String message) {
        return load(true, message,null, HttpStatus.BAD_REQUEST, TypeExceptionEnum.ERROR);
    }

    public static ResponseDto error(String message, HttpStatus status) {
        return load(true, message,null, status, null);
    }

    public static ResponseDto load(boolean success, ControllerMessageEnum messageEnum, Object data, HttpStatus status, TypeExceptionEnum type) {
        String dateTime = DateUtil.convertLocalDateTimeToString(LocalDateTime.now());
        return ResponseDto.builder()
                .message(messageEnum.getValue())
                .dateTime(dateTime)
                .success(success)
                .status(status)
                .data(data)
                .type(type)
                .build();
    }

    public static ResponseDto load(boolean success, String message, Object data, HttpStatus status, TypeExceptionEnum type) {
        String dateTime = DateUtil.convertLocalDateTimeToString(LocalDateTime.now());
        return ResponseDto.builder()
                .message(message)
                .dateTime(dateTime)
                .success(success)
                .status(status)
                .data(data)
                .type(type)
                .build();
    }

}