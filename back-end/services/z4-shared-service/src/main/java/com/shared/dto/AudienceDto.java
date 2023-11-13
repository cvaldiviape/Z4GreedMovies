package com.shared.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class AudienceDto extends CommonDto implements Searchable<Integer> {

    private Integer idAudience;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AudienceDto that = (AudienceDto) o;
        return Objects.equals(idAudience, that.idAudience);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idAudience);
    }

    @JsonIgnore
    @Override
    public Integer getSearcheableField() {
        return this.idAudience;
    }

}