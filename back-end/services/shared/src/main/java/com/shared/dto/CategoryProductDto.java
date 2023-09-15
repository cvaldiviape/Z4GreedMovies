package com.shared.dto;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryProductDto {

    private Integer idCategoryProduct;
    private String code;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryProductDto that = (CategoryProductDto) o;
        return Objects.equals(idCategoryProduct, that.idCategoryProduct) && Objects.equals(code, that.code) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategoryProduct, code, name);
    }

}