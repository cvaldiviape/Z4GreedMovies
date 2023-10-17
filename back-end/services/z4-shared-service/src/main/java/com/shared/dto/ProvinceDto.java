package com.shared.dto;

import com.shared.dto.custom.CommonDto;
import com.shared.utils.filter.Searchable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ProvinceDto  extends CommonDto implements Searchable<Integer> {

    private Integer idProvince;
    private DepartmentDto department;
    private Set<DistrictDto> listDistricts = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProvinceDto that = (ProvinceDto) o;
        return Objects.equals(idProvince, that.idProvince) && Objects.equals(department, that.department) && Objects.equals(listDistricts, that.listDistricts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idProvince, department, listDistricts);
    }

    @Override
    public Integer getSearcheableField() {
        return this.idProvince;
    }

}