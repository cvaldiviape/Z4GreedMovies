package com.shared.exception;

import com.shared.enums.TypeExceptionEnum;
import com.shared.error.GenericError;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Getter
public class Z4GreedMoviesException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;
    private HttpStatus state;
    private TypeExceptionEnum type;
    private String code;
    private String message;


    public Z4GreedMoviesException(HttpStatus state, String message) {
        super();
        this.state = state;
        this.message = message;
    }

    public Z4GreedMoviesException(HttpStatus state, String message, String messageOne) {
        super();
        this.state = state;
        this.message = message;
        this.message = messageOne;
    }

    public Z4GreedMoviesException(GenericError codeError, String message) {
        super();
        this.state = HttpStatus.BAD_REQUEST;
        this.type = codeError.getType();
        this.code = codeError.getCode();
        this.message =message;
    }

}