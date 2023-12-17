package com.catalogs.core.service.movie;

import com.catalogs.core.entity.MovieEntity;
import com.catalogs.core.entity.mapper.MovieMapper;
import com.catalogs.core.repository.MovieRepository;
import com.shared.core.service.impl.GenericDeleteService;
import com.shared.dto.external.catalogs.MovieDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("deleteMovieImpl")
public class DeleteMovieImpl extends GenericDeleteService<MovieEntity, MovieDto, Integer> {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public DeleteMovieImpl(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    @Override
    public JpaRepository<MovieEntity, Integer> getJpaRepository() {
        return this.movieRepository;
    }

    @Override
    public MovieDto toDto(MovieEntity countryEntity) {
        return this.movieMapper.toDto(countryEntity);
    }

    @Override
    public MovieEntity findEntityById(Integer idCountry) {
        return this.movieRepository.findById(idCountry)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.MOVIE.getValue(), idCountry));
    }

}