package com.shared.dto;

import com.shared.dto.custom.BaseMasterDto;
import com.shared.utils.filter.Searchable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CategoryProductDto extends BaseMasterDto implements Searchable<Integer> {

    private Integer idCategoryProduct;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CategoryProductDto that = (CategoryProductDto) o;
        return Objects.equals(idCategoryProduct, that.idCategoryProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idCategoryProduct);
    }

    @Override
    public Integer getSearcheableField() {
        return this.idCategoryProduct;
    }

}