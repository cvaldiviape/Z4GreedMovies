package com.z4greed.core.rest.controller;

import com.z4greed.core.models.dto.TypeStatusFilmShowDto;
import com.z4greed.core.models.entity.TypeStatusFilmShowEntity;
import com.z4greed.core.rest.common.HandlerCrudController;
import com.z4greed.core.service.common.CrudService;
import com.z4greed.core.service.common.HandlerCrudService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/type-status-film-shows")
public class TypeStatusFilmShowController extends HandlerCrudController<TypeStatusFilmShowDto, Integer> {

    private final HandlerCrudService<TypeStatusFilmShowEntity, TypeStatusFilmShowDto, Integer> typeStatusFilmShowService;

    public TypeStatusFilmShowController(@Qualifier("typeStatusFilmShowServiceImpl")HandlerCrudService<TypeStatusFilmShowEntity, TypeStatusFilmShowDto, Integer> typeStatusFilmShowService) {
        this.typeStatusFilmShowService = typeStatusFilmShowService;
    }

    @Override
    public CrudService<TypeStatusFilmShowDto, Integer> getCrudService() {
        return this.typeStatusFilmShowService;
    }

}