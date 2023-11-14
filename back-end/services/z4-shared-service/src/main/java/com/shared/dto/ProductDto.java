package com.shared.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shared.utils.filter.Searchable;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto implements Searchable<Integer> {

    private Integer idProduct;
    private String code;
    private String description;
    private BigDecimal price;
    private CategoryProductDto category;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return Objects.equals(idProduct, that.idProduct) && Objects.equals(code, that.code) && Objects.equals(description, that.description) && Objects.equals(price, that.price) && Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, code, description, price, category);
    }

    @JsonIgnore
    @Override
    public Integer getSearcheableField() {
        return this.idProduct;
    }

}