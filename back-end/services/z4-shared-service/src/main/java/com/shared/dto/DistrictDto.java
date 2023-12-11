package com.shared.dto;

import com.shared.dto.custom.CommonDto;
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
public class DistrictDto  extends CommonDto implements Searchable<Integer> {

    private Integer idDistrict;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DistrictDto that = (DistrictDto) o;
        return Objects.equals(idDistrict, that.idDistrict);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idDistrict);
    }

    @Override
    public Integer getSearcheableField() {
        return this.idDistrict;
    }

}