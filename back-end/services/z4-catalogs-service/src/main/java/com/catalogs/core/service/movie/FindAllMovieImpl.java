package com.catalogs.core.service.movie;

import com.catalogs.core.entity.MovieEntity;
import com.catalogs.core.entity.mapper.MovieMapper;
import com.catalogs.core.repository.MovieRepository;
import com.shared.core.service.FindAllService;
import com.shared.dto.MovieDto;
import com.shared.dto.custom.BasePageDto;
import com.shared.utils.PageUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service("findAllMovieImpl")
@Transactional
public class FindAllMovieImpl implements FindAllService<MovieDto> {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public FindAllMovieImpl(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    @Override
    public BasePageDto<MovieDto> findAll(Integer numberPage, Integer sizePage, String sortBy, String sortDir) {
        Pageable pageable = PageUtil.getPageable(numberPage, sizePage, sortBy, sortDir);
        Page<MovieEntity> pageData = this.movieRepository.findAll(pageable);
        List<MovieEntity> listEntities = pageData.getContent();

        Collection<MovieDto> listMovies = this.movieMapper.toListDtos(listEntities);

        return BasePageDto.<MovieDto>builder()
                .listElements(listMovies)
                .numberPage(pageData.getNumber())
                .sizePage(pageData.getSize())
                .totalElements(pageData.getTotalElements())
                .totalPages(pageData.getTotalPages())
                .isLastPage(pageData.isLast())
                .build();
    }

}