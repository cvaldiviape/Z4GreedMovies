package com.z4greed.core.rest.advice;


import com.z4greed.core.models.dto.custom.ErrorDetailResponseDTO;
import com.z4greed.core.models.dto.custom.ResponseDto;
import com.z4greed.shared.enums.ControllerMessageEnum;
import com.z4greed.shared.exception.Z4GreedMoviesException;
import com.z4greed.shared.exception.ResourceNotFoundException;
import com.z4greed.shared.utils.DateUtil;
import com.z4greed.shared.utils.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalHandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handlerResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest) {
        ResponseDto response = ResponseUtil.error(exception.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Z4GreedMoviesException.class)
    public ResponseEntity<Object> handlerZ4GreedMoviesException(Z4GreedMoviesException exception, WebRequest webRequest) {
        ResponseDto response = ResponseUtil.error(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}