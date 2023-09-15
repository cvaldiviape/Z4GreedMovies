package com.shared.utils;

import com.shared.exception.Z4GreedMoviesException;
import com.shared.interfaces.Searchable;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

public class FilterUtil {

    public static <T extends Searchable<U>, U> T find(List<T> list, U valueToSearch, String nameValueNotFound) {
        return list.stream()
                .filter(item -> filterGeneric(item, valueToSearch))
                .findFirst()
                .orElseThrow(() ->  new Z4GreedMoviesException(HttpStatus.BAD_REQUEST, nameValueNotFound));
    }

    public static <T extends Searchable<U>, U> Optional<T> find(List<T> list, U valueToSearch) {
        return list.stream()
                .filter(item -> filterGeneric(item, valueToSearch))
                .findFirst();
    }

    private static <T extends Searchable<U>, U> boolean filterGeneric(T  item, U valueToSearch) {
        try {
            return item.getSearcheableField().equals(valueToSearch);
        } catch (Exception e) {
            return false;
        }
    }

}