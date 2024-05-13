package com.catalogs.core.controller;

import com.catalogs.core.controller.interfaces.IGenreController;
import com.catalogs.core.entity.GenreEntity;
import com.shared.core.service.*;
import com.shared.core.service.impl.*;
import com.shared.dto.external.catalogs.GenreDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/genres")
public class GenreController implements IGenreController<GenreDto, Integer> {

    private final GenericFindAllService<GenreEntity, GenreDto, Integer> findAllService;
    private final GenericFindByIdService<GenreEntity, GenreDto, Integer> findByIdService;
    private final GenericCreateService<GenreEntity, GenreDto, Integer> createService;
    private final GenericUpdateService<GenreEntity, GenreDto, Integer> updateService;
    private final GenericDeleteService<GenreEntity, GenreDto, Integer> deleteService;
    private final GenericFindAllByListIdsService<GenreEntity, GenreDto, Integer> findAllByListIdsService;

    public GenreController(
            @Qualifier("findAllGenreImpl") GenericFindAllService<GenreEntity, GenreDto, Integer> findAllService,
            @Qualifier("findByIdGenreImpl") GenericFindByIdService<GenreEntity, GenreDto, Integer> findByIdService,
            @Qualifier("createGenreImpl") GenericCreateService<GenreEntity, GenreDto, Integer> createService,
            @Qualifier("updateGenreImpl") GenericUpdateService<GenreEntity, GenreDto, Integer> updateService,
            @Qualifier("deleteGenreImpl") GenericDeleteService<GenreEntity, GenreDto, Integer> deleteService,
            @Qualifier("findAllGenreByListIdsImpl") GenericFindAllByListIdsService<GenreEntity, GenreDto, Integer> findAllByListIdsService) {
        this.findAllService = findAllService;
        this.findByIdService = findByIdService;
        this.createService = createService;
        this.updateService = updateService;
        this.deleteService = deleteService;
        this.findAllByListIdsService = findAllByListIdsService;
    }

    @Override
    public FindAllService<GenreDto> getFindAllService() {
        return this.findAllService;
    }

    @Override
    public FindByIdService<GenreDto, Integer> getFindByIdService() {
        return this.findByIdService;
    }

    @Override
    public CreateService<GenreDto> getCreateService() {
        return this.createService;
    }

    @Override
    public UpdateService<GenreDto, Integer> getUpdateService() {
        return this.updateService;
    }

    @Override
    public DeleteService<GenreDto, Integer> getDeleteService() {
        return this.deleteService;
    }

    @Override
    public FindAllByListIdsService<GenreDto, Integer> getFindAllByListIdsService() {
        return this.findAllByListIdsService;
    }

}