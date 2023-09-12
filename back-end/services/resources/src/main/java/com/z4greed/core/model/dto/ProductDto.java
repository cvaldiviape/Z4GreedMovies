package com.z4greed.core.model.dto;

import lombok.*;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    private Integer idProduct;
    private String code;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private Integer idCategoryProduct;
    private CategoryProductDto categoryProduct;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return Objects.equals(idProduct, that.idProduct) && Objects.equals(code, that.code) && Objects.equals(description, that.description) && Objects.equals(price, that.price) && Objects.equals(stock, that.stock) && Objects.equals(idCategoryProduct, that.idCategoryProduct) && Objects.equals(categoryProduct, that.categoryProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, code, description, price, stock, idCategoryProduct, categoryProduct);
    }

}