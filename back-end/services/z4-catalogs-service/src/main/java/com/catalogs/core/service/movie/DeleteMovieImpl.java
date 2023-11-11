package com.catalogs.core.service.movie;

import com.catalogs.core.entity.MovieEntity;
import com.catalogs.core.entity.mapper.MovieMapper;
import com.catalogs.core.repository.MovieRepository;
import com.shared.core.service.DeleteService;
import com.shared.dto.MovieDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("deleteMovieImpl")
@Transactional
public class DeleteMovieImpl implements DeleteService<MovieDto, Integer> {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public DeleteMovieImpl(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    @Override
    public MovieDto delete(Integer idMovie) {
        MovieEntity movieEntity = this.findMovieEntityById(idMovie);
        this.movieRepository.delete(movieEntity);
        return this.movieMapper.toDto(movieEntity);
    }

    private MovieEntity findMovieEntityById(Integer id) {
        return this.movieRepository.findById(id)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.MOVIE.getValue(), id));
    }

}