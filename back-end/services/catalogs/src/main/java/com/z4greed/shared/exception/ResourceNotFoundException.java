package com.z4greed.shared.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.io.Serial;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;
    private String nameField;
    private Integer valueField;

    public ResourceNotFoundException(String nameField, Integer valueField) {
        super(String.format("Item not found, %s: '%s'", nameField, valueField));
        this.nameField = nameField;
        this.valueField = valueField;
    }

}