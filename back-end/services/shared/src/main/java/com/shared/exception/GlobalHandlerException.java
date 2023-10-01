package com.shared.exception;

import com.shared.utils.response.ResponseDto;
import com.shared.utils.response.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class GlobalHandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> manejarTodasExcepciones(Exception exception, WebRequest request) {
        if (exception instanceof Z4GreedMoviesException) {
            Z4GreedMoviesException ex = (Z4GreedMoviesException) exception;
            ResponseDto response = ResponseUtil.error(ex.getMessage(), ex.getCode(), ex.getType());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            exception.printStackTrace();
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}