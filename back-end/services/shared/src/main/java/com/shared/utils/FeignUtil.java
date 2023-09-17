package com.shared.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shared.utils.response.ResponseDto;
import lombok.NoArgsConstructor;

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
        Object[] messageError = { nameValueNotFound };
        ObjectMapper mapper = new ObjectMapper();
        Object data = Optional.ofNullable(apiResponse.getData())
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(messageError));
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
        Object[] messageError = { nameValueNotFound };
        ObjectMapper mapper = new ObjectMapper();
        Object data = Optional.ofNullable(apiResponse.getData())
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(messageError));
        return (T) mapper.convertValue(data, clase);
    }

}