package com.catalogs.core.service.movie;

import com.catalogs.core.entity.MovieEntity;
import com.catalogs.core.entity.mapper.MovieMapper;
import com.catalogs.core.repository.MovieRepository;
import com.shared.core.service.FindAllByListIdsService;
import com.shared.dto.MovieDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.List;

@Service("findAllMovieByListIdsImpl")
@Transactional
public class FindAllMovieByListIdsImpl implements FindAllByListIdsService<MovieDto, Integer> {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public FindAllMovieByListIdsImpl(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    @Override
    public Collection<MovieDto> findAllByListIds(Collection<Integer> listIds) {
        List<MovieEntity> listEntities = this.movieRepository.findAllById(listIds);
        return this.movieMapper.toListDtos(listEntities);
    }

}