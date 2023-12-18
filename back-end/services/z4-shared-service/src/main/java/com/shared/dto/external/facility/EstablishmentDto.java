package com.shared.dto.external.facility;

import com.shared.dto.external.ubigeo.DistrictDto;
import com.shared.utils.filter.Searchable;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstablishmentDto implements Searchable<Integer> {

    private Integer idEstablishment;
    private String code;
    private Integer idDistrict;
    private DistrictDto district;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstablishmentDto that = (EstablishmentDto) o;
        return Objects.equals(idEstablishment, that.idEstablishment) && Objects.equals(code, that.code) && Objects.equals(idDistrict, that.idDistrict) && Objects.equals(district, that.district);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstablishment, code, idDistrict, district);
    }

    @Override
    public Integer getSearcheableField() {
        return this.idEstablishment;
    }

}