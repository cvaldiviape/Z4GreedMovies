package com.shared.dto.custom;

import lombok.*;

import java.util.Collection;
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
    private Collection<T> listElements;

}