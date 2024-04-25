package com.catalogs.core.controller;

import com.catalogs.core.controller.interfaces.IAudienceController;
import com.catalogs.core.entity.AudienceEntity;
import com.shared.core.controller.*;
import com.shared.core.service.*;
import com.shared.core.service.impl.*;
import com.shared.dto.external.catalogs.AudienceDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/audiences")
public class AudienceController implements IAudienceController<AudienceDto, Integer> {

    private final GenericFindAllService<AudienceEntity, AudienceDto, Integer> findAllService;
    private final GenericFindByIdService<AudienceEntity, AudienceDto, Integer> findByIdService;
    private final GenericCreateService<AudienceEntity, AudienceDto, Integer> createService;
    private final GenericUpdateService<AudienceEntity, AudienceDto, Integer> updateService;
    private final GenericDeleteService<AudienceEntity, AudienceDto, Integer> deleteService;
    private final GenericFindAllByListIdsService<AudienceEntity, AudienceDto, Integer> findAllByListIdsService;

    public AudienceController(
            @Qualifier("findAllAudienceImpl") GenericFindAllService<AudienceEntity, AudienceDto, Integer> findAllService,
            @Qualifier("findByIdAudienceImpl") GenericFindByIdService<AudienceEntity, AudienceDto, Integer> findByIdService,
            @Qualifier("createAudienceImpl") GenericCreateService<AudienceEntity, AudienceDto, Integer> createService,
            @Qualifier("updateAudienceImpl") GenericUpdateService<AudienceEntity, AudienceDto, Integer> updateService,
            @Qualifier("deleteAudienceImpl") GenericDeleteService<AudienceEntity, AudienceDto, Integer> deleteService,
            @Qualifier("findAllAudienceByListIdsImpl") GenericFindAllByListIdsService<AudienceEntity, AudienceDto, Integer> findAllByListIdsService) {
        this.findAllService = findAllService;
        this.findByIdService = findByIdService;
        this.createService = createService;
        this.updateService = updateService;
        this.deleteService = deleteService;
        this.findAllByListIdsService = findAllByListIdsService;
    }

    @Override
    public FindAllService<AudienceDto> getFindAllService() {
        return this.findAllService;
    }

    @Override
    public FindByIdService<AudienceDto, Integer> getFindByIdService() {
        return this.findByIdService;
    }

    @Override
    public CreateService<AudienceDto> getCreateService() {
        return this.createService;
    }

    @Override
    public UpdateService<AudienceDto, Integer> getUpdateService() {
        return this.updateService;
    }

    @Override
    public DeleteService<AudienceDto, Integer> getDeleteService() {
        return this.deleteService;
    }

    @Override
    public FindAllByListIdsService<AudienceDto, Integer> getFindAllByListIdsService() {
        return this.findAllByListIdsService;
    }

}