package com.z4greed.shared.utils;

import com.z4greed.shared.exception.Z4GreedMoviesException;
import org.springframework.http.HttpStatus;

public class ValidateUtil {

    public static void evaluate(Boolean expression, String messageError){
        if(expression){
            throw new Z4GreedMoviesException(HttpStatus.BAD_REQUEST, messageError);
        }
    }
}
