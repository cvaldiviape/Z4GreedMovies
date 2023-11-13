package com.catalogs.core.service.movie;

import com.catalogs.core.entity.MovieEntity;
import com.catalogs.core.entity.mapper.MovieMapper;
import com.catalogs.core.repository.MovieRepository;
import com.shared.core.service.impl.GenericFindAllByListIdsService;
import com.shared.dto.MovieDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service("findAllMovieByListIdsImpl")
public class FindAllMovieByListIdsImpl extends GenericFindAllByListIdsService<MovieEntity, MovieDto, Integer> {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public FindAllMovieByListIdsImpl(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    @Override
    public JpaRepository<MovieEntity, Integer> getJpaRepository() {
        return this.movieRepository;
    }

    @Override
    public Collection<MovieDto> toListDtos(Collection<MovieEntity> listEntities) {
        return this.movieMapper.toListDtos(listEntities);
    }

}