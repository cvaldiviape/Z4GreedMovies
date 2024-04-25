package com.catalogs.core.controller;

import com.catalogs.core.controller.interfaces.IStudioController;
import com.catalogs.core.entity.StudioEntity;
import com.shared.core.controller.*;
import com.shared.core.service.*;
import com.shared.core.service.impl.*;
import com.shared.dto.external.catalogs.StudioDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/studios")
public class StudioController implements IStudioController<StudioDto, Integer> {

    private final GenericFindAllService<StudioEntity, StudioDto, Integer> findAllService;
    private final GenericFindByIdService<StudioEntity, StudioDto, Integer> findByIdService;
    private final CreateService<StudioDto> createService;
    private final UpdateService<StudioDto, Integer> updateService;
    private final GenericDeleteService<StudioEntity, StudioDto, Integer> deleteService;
    private final GenericFindAllByListIdsService<StudioEntity, StudioDto, Integer> findAllByListIdsService;

    public StudioController(
            @Qualifier("findAllStudioImpl") GenericFindAllService<StudioEntity, StudioDto, Integer> findAllService,
            @Qualifier("findByIdStudioImpl") GenericFindByIdService<StudioEntity, StudioDto, Integer> findByIdService,
            @Qualifier("createStudioImpl") CreateService<StudioDto> createService,
            @Qualifier("updateStudioImpl") UpdateService<StudioDto, Integer> updateService,
            @Qualifier("deleteStudioImpl") GenericDeleteService<StudioEntity, StudioDto, Integer> deleteService,
            @Qualifier("findAllStudioByListIdsImpl") GenericFindAllByListIdsService<StudioEntity, StudioDto, Integer> findAllByListIdsService) {
        this.findAllService = findAllService;
        this.findByIdService = findByIdService;
        this.createService = createService;
        this.updateService = updateService;
        this.deleteService = deleteService;
        this.findAllByListIdsService = findAllByListIdsService;
    }

    @Override
    public FindAllService<StudioDto> getFindAllService() {
        return this.findAllService;
    }

    @Override
    public FindByIdService<StudioDto, Integer> getFindByIdService() {
        return this.findByIdService;
    }

    @Override
    public CreateService<StudioDto> getCreateService() {
        return this.createService;
    }

    @Override
    public UpdateService<StudioDto, Integer> getUpdateService() {
        return this.updateService;
    }

    @Override
    public DeleteService<StudioDto, Integer> getDeleteService() {
        return this.deleteService;
    }

    @Override
    public FindAllByListIdsService<StudioDto, Integer> getFindAllByListIdsService() {
        return this.findAllByListIdsService;
    }

}