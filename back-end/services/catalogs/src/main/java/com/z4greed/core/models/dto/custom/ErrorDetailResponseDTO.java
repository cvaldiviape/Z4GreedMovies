package com.z4greed.core.models.dto.custom;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDetailResponseDTO {

    private String timestamp;
    private String message;
    private String detail;

}