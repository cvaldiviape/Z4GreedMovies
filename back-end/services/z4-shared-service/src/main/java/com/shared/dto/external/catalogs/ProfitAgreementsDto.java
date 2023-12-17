package com.shared.dto.external.catalogs;

import lombok.*;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfitAgreementsDto {

    private Integer idProfitAgreements;
    private BigDecimal studio;
    private BigDecimal house;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfitAgreementsDto that = (ProfitAgreementsDto) o;
        return Objects.equals(idProfitAgreements, that.idProfitAgreements) && Objects.equals(studio, that.studio) && Objects.equals(house, that.house);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProfitAgreements, studio, house);
    }

}