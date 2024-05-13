package com.catalogs.core.controller;

import com.catalogs.core.controller.interfaces.IMovieController;
import com.catalogs.core.entity.MovieEntity;
import com.shared.core.service.*;
import com.shared.core.service.impl.*;
import com.shared.dto.external.catalogs.MovieDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/movies")
public class MovieController implements IMovieController<MovieDto, Integer> {

    private final GenericFindAllService<MovieEntity, MovieDto, Integer> findAllService;
    private final GenericFindByIdService<MovieEntity, MovieDto, Integer> findByIdService;
    private final CreateService<MovieDto> createService;
    private final UpdateService<MovieDto, Integer> updateService;
    private final GenericDeleteService<MovieEntity, MovieDto, Integer> deleteService;
    private final GenericFindAllByListIdsService<MovieEntity, MovieDto, Integer> findAllByListIdsService;

    public MovieController(
            @Qualifier("findAllMovieImpl") GenericFindAllService<MovieEntity, MovieDto, Integer> findAllService,
            @Qualifier("findByIdMovieImpl") GenericFindByIdService<MovieEntity, MovieDto, Integer> findByIdService,
            @Qualifier("createMovieImpl") CreateService<MovieDto> createService,
            @Qualifier("updateMovieImpl") UpdateService<MovieDto, Integer> updateService,
            @Qualifier("deleteMovieImpl") GenericDeleteService<MovieEntity, MovieDto, Integer> deleteService,
            @Qualifier("findAllMovieByListIdsImpl") GenericFindAllByListIdsService<MovieEntity, MovieDto, Integer> findAllByListIdsService
    ) {
        this.findAllService = findAllService;
        this.findByIdService = findByIdService;
        this.createService = createService;
        this.updateService = updateService;
        this.deleteService = deleteService;
        this.findAllByListIdsService = findAllByListIdsService;
    }

    @Override
    public FindAllService<MovieDto> getFindAllService() {
        return this.findAllService;
    }

    @Override
    public FindByIdService<MovieDto, Integer> getFindByIdService() {
        return this.findByIdService;
    }

    @Override
    public CreateService<MovieDto> getCreateService() {
        return this.createService;
    }

    @Override
    public UpdateService<MovieDto, Integer> getUpdateService() {
        return this.updateService;
    }

    @Override
    public DeleteService<MovieDto, Integer> getDeleteService() {
        return this.deleteService;
    }

    @Override
    public FindAllByListIdsService<MovieDto, Integer> getFindAllByListIdsService() {
        return this.findAllByListIdsService;
    }

}