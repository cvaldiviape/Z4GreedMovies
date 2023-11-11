package com.catalogs.core.service.movie;

import com.catalogs.core.entity.MovieEntity;
import com.catalogs.core.entity.mapper.MovieMapper;
import com.catalogs.core.repository.MovieRepository;
import com.shared.core.service.FindByIdService;
import com.shared.dto.MovieDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("findMovieByIdImpl")
@Transactional
public class FindMovieByIdImpl implements FindByIdService<MovieDto, Integer> {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public FindMovieByIdImpl(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    @Override
    public MovieDto findById(Integer idMovie) {
        MovieEntity entity = this.findMovieEntityById(idMovie);
        return this.movieMapper.toDto(entity);
    }

    private MovieEntity findMovieEntityById(Integer id) {
        return this.movieRepository.findById(id)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.MOVIE.getValue(), id));
    }

}
