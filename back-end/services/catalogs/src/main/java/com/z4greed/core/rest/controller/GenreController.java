package com.z4greed.core.rest.controller;

import com.z4greed.core.models.dto.GenreDto;
import com.z4greed.core.models.entity.GenreEntity;
import com.z4greed.core.rest.common.HandlerCrudController;
import com.z4greed.core.service.common.CrudService;
import com.z4greed.core.service.common.HandlerCrudService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/genres")
public class GenreController extends HandlerCrudController<GenreDto, Integer> {

    private final HandlerCrudService<GenreEntity, GenreDto,Integer> genreService;

    public GenreController(@Qualifier("genreServiceImpl")HandlerCrudService<GenreEntity, GenreDto, Integer> genreService) {
        this.genreService = genreService;
    }

    @Override
    public CrudService<GenreDto, Integer> getCrudService() {
        return this.genreService;
    }

}