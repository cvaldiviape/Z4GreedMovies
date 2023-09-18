package com.shared.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class MovieAudienceDto extends BaseMasterDto implements Searchable<Integer> {

    private Integer idMovieAudience;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MovieAudienceDto that = (MovieAudienceDto) o;
        return Objects.equals(idMovieAudience, that.idMovieAudience);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idMovieAudience);
    }

    @JsonIgnore
    @Override
    public Integer getSearcheableField() {
        return this.idMovieAudience;
    }

}