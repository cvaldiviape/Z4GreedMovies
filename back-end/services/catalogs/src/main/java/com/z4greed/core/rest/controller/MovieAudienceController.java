package com.z4greed.core.rest.controller;

import com.z4greed.core.models.dto.MovieAudienceDto;
import com.z4greed.core.models.entity.MovieAudienceEntity;
import com.z4greed.core.rest.common.HandlerCrudController;
import com.z4greed.core.service.common.CrudService;
import com.z4greed.core.service.common.HandlerCrudService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/movie-audiences")
public class MovieAudienceController extends HandlerCrudController<MovieAudienceDto, Integer> {

    private final HandlerCrudService<MovieAudienceEntity, MovieAudienceDto, Integer> movieAudienceService;

    public MovieAudienceController(@Qualifier("movieAudienceServiceImpl")HandlerCrudService<MovieAudienceEntity, MovieAudienceDto, Integer> movieAudienceService) {
        this.movieAudienceService = movieAudienceService;
    }

    @Override
    public CrudService<MovieAudienceDto, Integer> getCrudService() {
        return this.movieAudienceService;
    }

}