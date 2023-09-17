package com.shared.utils;

import com.shared.error.GeneralErrorEnum;
import com.shared.error.TypeEvaluationEnum;
import com.shared.error.GenericError;
import com.shared.exception.Z4GreedMoviesException;

import java.util.Collection;

public class ValidateUtil {

    public static void evaluate(TypeEvaluationEnum typeEvaluation, boolean expression, GenericError codeError){
        if (typeEvaluation.equals(TypeEvaluationEnum.TRUE)) {
            if (expression) {
                throwZ4GreedMoviesException(codeError);
            }
        }
        if (typeEvaluation.equals(TypeEvaluationEnum.FALSE)) {
            if (!expression) {
                throwZ4GreedMoviesException(codeError);
            }
        }
    }

    public static void evaluate(TypeEvaluationEnum typeEvaluation, boolean expression, GenericError codeError, Object... value) {
        if(typeEvaluation.equals(TypeEvaluationEnum.TRUE)) {
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

    public static void hasData(Collection<?> list, GenericError codeError) {
        if (!hasData(list)) {
            throwZ4GreedMoviesException(codeError);
        }
    }

    public static void hasData(Collection<?> list, Object[] valueEmpty) {
        if (!hasData(list)) {
            throwZ4GreedMoviesException(GeneralErrorEnum.ER000003, valueEmpty);
        }
    }

    public static boolean hasData(Collection<?> list){
        return list != null && !list.isEmpty();
    }

    private static void throwZ4GreedMoviesException(GenericError codeError) {
        throw new Z4GreedMoviesException(codeError);
    }

    private static void throwZ4GreedMoviesException(GenericError codeError, Object[] value) {
        String message = String.format(codeError.getMessage(), value);
        throw new Z4GreedMoviesException(codeError, message);
    }

    public static Z4GreedMoviesException throwNotFoundException(Object... messageError) {
        return getZ4GreedMoviesException(GeneralErrorEnum.ER000004, messageError);
    }

    public static Z4GreedMoviesException throwNotFoundException(String valueNotFound) {
        return getZ4GreedMoviesException(GeneralErrorEnum.ER000002, (Object) valueNotFound);
    }

    private static Z4GreedMoviesException getZ4GreedMoviesException(GeneralErrorEnum errorEnum, Object... messageError) {
        String message = String.format(errorEnum.getMessage(), messageError);
        return new Z4GreedMoviesException(errorEnum, message);
    }

}