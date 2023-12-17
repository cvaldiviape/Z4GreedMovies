package com.shared.dto.external.ubigeo;

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
public class DepartmentDto extends CommonDto implements Searchable<Integer> {

    private Integer idDepartment;
    private Set<ProvinceDto> listProvinces = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DepartmentDto that = (DepartmentDto) o;
        return Objects.equals(idDepartment, that.idDepartment) && Objects.equals(listProvinces, that.listProvinces);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idDepartment, listProvinces);
    }

    @Override
    public Integer getSearcheableField() {
        return this.idDepartment;
    }

}