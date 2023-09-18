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
public class LanguageDto extends BaseMasterDto implements Searchable<Integer> {

    private Integer idLanguage;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LanguageDto that = (LanguageDto) o;
        return Objects.equals(idLanguage, that.idLanguage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idLanguage);
    }

    @Override
    public Integer getSearcheableField() {
        return this.idLanguage;
    }

}