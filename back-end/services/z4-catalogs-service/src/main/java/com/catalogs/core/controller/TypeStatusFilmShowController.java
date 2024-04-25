package com.catalogs.core.controller;

import com.catalogs.core.controller.interfaces.ITypeStatusFilmShowController;
import com.catalogs.core.entity.TypeStatusFilmShowEntity;
import com.shared.core.controller.*;
import com.shared.core.service.*;
import com.shared.core.service.impl.*;
import com.shared.dto.external.catalogs.TypeStatusFilmShowDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/type-status-film-shows")
public class TypeStatusFilmShowController implements ITypeStatusFilmShowController<TypeStatusFilmShowDto, Integer> {

    private final GenericFindAllService<TypeStatusFilmShowEntity, TypeStatusFilmShowDto, Integer> findAllService;
    private final GenericFindByIdService<TypeStatusFilmShowEntity, TypeStatusFilmShowDto, Integer> findByIdService;
    private final GenericCreateService<TypeStatusFilmShowEntity, TypeStatusFilmShowDto, Integer> createService;
    private final GenericUpdateService<TypeStatusFilmShowEntity, TypeStatusFilmShowDto, Integer> updateService;
    private final GenericDeleteService<TypeStatusFilmShowEntity, TypeStatusFilmShowDto, Integer> deleteService;
    private final GenericFindAllByListIdsService<TypeStatusFilmShowEntity, TypeStatusFilmShowDto, Integer> findAllByListIdsService;

    public TypeStatusFilmShowController(
            @Qualifier("findAllTypeStatusFilmShowImpl") GenericFindAllService<TypeStatusFilmShowEntity, TypeStatusFilmShowDto, Integer> findAllService,
            @Qualifier("findByIdTypeStatusFilmShowImpl") GenericFindByIdService<TypeStatusFilmShowEntity, TypeStatusFilmShowDto, Integer> findByIdService,
            @Qualifier("createTypeStatusFilmShowImpl") GenericCreateService<TypeStatusFilmShowEntity, TypeStatusFilmShowDto, Integer> createService,
            @Qualifier("updateTypeStatusFilmShowImpl") GenericUpdateService<TypeStatusFilmShowEntity, TypeStatusFilmShowDto, Integer> updateService,
            @Qualifier("deleteTypeStatusFilmShowImpl") GenericDeleteService<TypeStatusFilmShowEntity, TypeStatusFilmShowDto, Integer> deleteService,
            @Qualifier("findAllTypeStatusFilmShowByListIdsImpl") GenericFindAllByListIdsService<TypeStatusFilmShowEntity, TypeStatusFilmShowDto, Integer> findAllByListIdsService) {
        this.findAllService = findAllService;
        this.findByIdService = findByIdService;
        this.createService = createService;
        this.updateService = updateService;
        this.deleteService = deleteService;
        this.findAllByListIdsService = findAllByListIdsService;
    }

    @Override
    public FindAllService<TypeStatusFilmShowDto> getFindAllService() {
        return this.findAllService;
    }

    @Override
    public FindByIdService<TypeStatusFilmShowDto, Integer> getFindByIdService() {
        return this.findByIdService;
    }

    @Override
    public CreateService<TypeStatusFilmShowDto> getCreateService() {
        return this.createService;
    }

    @Override
    public UpdateService<TypeStatusFilmShowDto, Integer> getUpdateService() {
        return this.updateService;
    }

    @Override
    public DeleteService<TypeStatusFilmShowDto, Integer> getDeleteService() {
        return this.deleteService;
    }

    @Override
    public FindAllByListIdsService<TypeStatusFilmShowDto, Integer> getFindAllByListIdsService() {
        return this.findAllByListIdsService;
    }

}