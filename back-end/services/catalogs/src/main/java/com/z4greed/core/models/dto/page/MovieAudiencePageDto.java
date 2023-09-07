package com.z4greed.core.models.dto.page;

import com.z4greed.core.models.dto.MovieAudienceDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class MovieAudiencePageDto {

    private List<MovieAudienceDto> listMovieAudiences;

}