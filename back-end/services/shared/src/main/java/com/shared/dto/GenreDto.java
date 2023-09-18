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
public class GenreDto extends BaseMasterDto implements Searchable<Integer> {

    private Integer idGenre;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GenreDto genreDto = (GenreDto) o;
        return Objects.equals(idGenre, genreDto.idGenre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idGenre);
    }

    @Override
    public Integer getSearcheableField() {
        return this.idGenre;
    }

}