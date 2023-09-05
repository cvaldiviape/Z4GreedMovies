package com.z4greed.core.models.dto.base;

import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BasePageDto<T> {

    private Integer numberPage;
    private Integer sizePage;
    private Integer totalPages;
    private Boolean isLastPage;
    private Long totalElements;
    private List<T> listElements;

}