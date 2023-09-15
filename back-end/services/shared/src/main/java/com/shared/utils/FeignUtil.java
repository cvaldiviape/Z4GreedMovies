package com.shared.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shared.dto.custom.ResponseDto;
import com.shared.exception.Z4GreedMoviesException;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
public class FeignUtil {

    public static <T> List<T> convertDataToList(ResponseDto apiResponse, Class<T> clase) {
        ObjectMapper mapper = new ObjectMapper();
        if (apiResponse.getData() != null) {
            return mapper.convertValue(apiResponse.getData(),
                    mapper.getTypeFactory().constructCollectionType(List.class, clase));
        }
        return null;
    }

    public static <T> List<T> convertDataToList(ResponseDto apiResponse, Class<T> clase, String nameValueNotFound) {
        ObjectMapper mapper = new ObjectMapper();
        Object data = Optional.ofNullable(apiResponse.getData())
                .orElseThrow(() -> new Z4GreedMoviesException(HttpStatus.NOT_FOUND, nameValueNotFound + " no existe"));
        return mapper.convertValue(data, mapper.getTypeFactory().constructCollectionType(List.class, clase));
    }

    public static <T> T convertDataToObject(ResponseDto apiResponse, Class<T> clase) {
        ObjectMapper mapper = new ObjectMapper();
        if (apiResponse.getData() != null) {
            return (T) mapper.convertValue(apiResponse.getData(), clase);
        }
        return null;
    }

    public static <T> T convertDataToObject(ResponseDto apiResponse, Class<T> clase, String nameValueNotFound) {
        ObjectMapper mapper = new ObjectMapper();
        Object data = Optional.ofNullable(apiResponse.getData())
                .orElseThrow(() -> new Z4GreedMoviesException(HttpStatus.NOT_FOUND, nameValueNotFound + " no existen"));
        return (T) mapper.convertValue(data, clase);
    }

}