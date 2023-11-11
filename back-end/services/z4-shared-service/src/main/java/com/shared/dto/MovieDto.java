package com.shared.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.shared.dto.custom.CommonDto;
import com.shared.utils.filter.Searchable;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class MovieDto extends CommonDto implements Searchable<Integer> {

    private Integer idMovie;
    private String synopsis;
    private Integer year;
//    @JsonDeserialize(using = LocalTimeDeserializer.class)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss")
    private LocalTime duration;
    private String urlImage;
    private StudioDto studio;
    private MovieAudienceDto movieAudience;
    private Set<GenreDto> listGenres = new HashSet<>();
    private Set<LanguageDto> listLanguages = new HashSet<>();
    private ProfitAgreementsDto profitAgreements;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MovieDto movieDto = (MovieDto) o;
        return Objects.equals(idMovie, movieDto.idMovie) && Objects.equals(synopsis, movieDto.synopsis) && Objects.equals(year, movieDto.year) && Objects.equals(duration, movieDto.duration) && Objects.equals(urlImage, movieDto.urlImage) && Objects.equals(studio, movieDto.studio) && Objects.equals(movieAudience, movieDto.movieAudience) && Objects.equals(listGenres, movieDto.listGenres) && Objects.equals(listLanguages, movieDto.listLanguages) && Objects.equals(profitAgreements, movieDto.profitAgreements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idMovie, synopsis, year, duration, urlImage, studio, movieAudience, listGenres, listLanguages, profitAgreements);
    }

    @Override
    public Integer getSearcheableField() {
        return idMovie;
    }

}