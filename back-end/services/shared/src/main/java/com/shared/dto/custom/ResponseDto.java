package com.shared.dto.custom;

import com.shared.enums.TypeExceptionEnum;
import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDto {

    private String dateTime;
    private Boolean success;
    private String message;
    private Object data;
    private HttpStatus status;
    private TypeExceptionEnum type;

}