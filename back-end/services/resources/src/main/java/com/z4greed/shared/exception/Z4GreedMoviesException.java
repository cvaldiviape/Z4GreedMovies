package com.z4greed.shared.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Getter
@Setter
public class Z4GreedMoviesException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;
    private HttpStatus state;
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

}