package com.catalogs.core.controller;

import com.catalogs.core.controller.interfaces.ILanguageController;
import com.catalogs.core.entity.LanguageEntity;
import com.shared.core.service.*;
import com.shared.core.service.impl.*;
import com.shared.dto.external.catalogs.LanguageDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/languages")
public class LanguageController implements ILanguageController<LanguageDto, Integer> {

    private final GenericFindAllService<LanguageEntity, LanguageDto, Integer> findAllService;
    private final GenericFindByIdService<LanguageEntity, LanguageDto, Integer> findByIdService;
    private final GenericCreateService<LanguageEntity, LanguageDto, Integer> createService;
    private final GenericUpdateService<LanguageEntity, LanguageDto, Integer> updateService;
    private final GenericDeleteService<LanguageEntity, LanguageDto, Integer> deleteService;
    private final GenericFindAllByListIdsService<LanguageEntity, LanguageDto, Integer> findAllByListIdsService;

    public LanguageController(
            @Qualifier("findAllLanguageImpl") GenericFindAllService<LanguageEntity, LanguageDto, Integer> findAllService,
            @Qualifier("findByIdLanguageImpl") GenericFindByIdService<LanguageEntity, LanguageDto, Integer> findByIdService,
            @Qualifier("createLanguageImpl") GenericCreateService<LanguageEntity, LanguageDto, Integer> createService,
            @Qualifier("updateLanguageImpl") GenericUpdateService<LanguageEntity, LanguageDto, Integer> updateService,
            @Qualifier("deleteLanguageImpl") GenericDeleteService<LanguageEntity, LanguageDto, Integer> deleteService,
            @Qualifier("findAllLanguageByListIdsImpl") GenericFindAllByListIdsService<LanguageEntity, LanguageDto, Integer> findAllByListIdsService) {
        this.findAllService = findAllService;
        this.findByIdService = findByIdService;
        this.createService = createService;
        this.updateService = updateService;
        this.deleteService = deleteService;
        this.findAllByListIdsService = findAllByListIdsService;
    }

    @Override
    public FindAllService<LanguageDto> getFindAllService() {
        return this.findAllService;
    }

    @Override
    public FindByIdService<LanguageDto, Integer> getFindByIdService() {
        return this.findByIdService;
    }

    @Override
    public CreateService<LanguageDto> getCreateService() {
        return this.createService;
    }

    @Override
    public UpdateService<LanguageDto, Integer> getUpdateService() {
        return this.updateService;
    }

    @Override
    public DeleteService<LanguageDto, Integer> getDeleteService() {
        return this.deleteService;
    }

    @Override
    public FindAllByListIdsService<LanguageDto, Integer> getFindAllByListIdsService() {
        return this.findAllByListIdsService;
    }

}