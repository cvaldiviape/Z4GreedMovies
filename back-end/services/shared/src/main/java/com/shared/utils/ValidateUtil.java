package com.shared.utils;

import com.shared.enums.TypeEvaluationEnum;
import com.shared.error.GenericError;
import com.shared.exception.Z4GreedMoviesException;
import org.springframework.http.HttpStatus;

import java.util.Collection;

public class ValidateUtil {

    public static void evaluate(TypeEvaluationEnum typeEvaluation, boolean expression, String messageError){
        if (typeEvaluation.equals(TypeEvaluationEnum.TRUE)) {
            if (expression) {
                throwZ4GreedMoviesException(messageError);
            }
        }
        if (typeEvaluation.equals(TypeEvaluationEnum.FALSE)) {
            if (!expression) {
                throwZ4GreedMoviesException(messageError);
            }
        }
    }

    public static void evaluar(TypeEvaluationEnum typeEvaluation, boolean expression, GenericError codeError, Object... value) {
        if( typeEvaluation.equals(TypeEvaluationEnum.TRUE)) {
            if (expression) {
                throwZ4GreedMoviesException(codeError, value);
            }
        }
        if (typeEvaluation.equals(TypeEvaluationEnum.FALSE)){
            if (!expression) {
                throwZ4GreedMoviesException(codeError, value);
            }
        }
    }

    public static void hasData(Collection<?> list, String messageError) {
        if (!hasData(list)) {
            throwZ4GreedMoviesException(messageError);
        }
    }

    public static boolean hasData(Collection<?> list){
        return list != null && !list.isEmpty();
    }

    private static void throwZ4GreedMoviesException(String messageError) {
        throw new Z4GreedMoviesException(HttpStatus.BAD_REQUEST, messageError);
    }

    private static void throwZ4GreedMoviesException(GenericError codeError, Object[] value) {
        String message = String.format(codeError.getMessage(), value);
        throw new Z4GreedMoviesException(codeError, message);
    }
}
