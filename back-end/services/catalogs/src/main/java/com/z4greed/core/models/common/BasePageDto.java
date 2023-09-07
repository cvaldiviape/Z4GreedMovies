package com.z4greed.core.models.common;

import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BasePageDto<T extends BaseDto> {

    private Integer numberPage;
    private Integer sizePage;
    private Integer totalPages;
    private Boolean isLastPage;
    private Long totalElements;
    private List<T> listElements;

}