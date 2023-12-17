package com.ubigeo.core.controller;

import com.ubigeo.core.entity.DistrictEntity;
import com.shared.core.controller.*;
import com.shared.core.service.*;
import com.shared.core.service.impl.*;
import com.shared.dto.external.ubigeo.DistrictDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/districts")
public class DistrictController  implements FindAllController<DistrictDto>, FindByIdController<DistrictDto, Integer>, CreateController<DistrictDto>, UpdateController<DistrictDto, Integer>, DeleteController<DistrictDto, Integer>, FindAllByListIdsController<DistrictDto, Integer> {

    private final GenericFindAllService<DistrictEntity, DistrictDto, Integer> findAllService;
    private final GenericFindByIdService<DistrictEntity, DistrictDto, Integer> findByIdService;
    private final CreateService<DistrictDto> createService;
    private final UpdateService<DistrictDto, Integer> updateService;
    private final GenericDeleteService<DistrictEntity, DistrictDto, Integer> deleteService;
    private final GenericFindAllByListIdsService<DistrictEntity, DistrictDto, Integer> findAllByListIdsService;

    public DistrictController(
        @Qualifier("findAllDistrictImpl") GenericFindAllService<DistrictEntity, DistrictDto, Integer> findAllService,
        @Qualifier("findByIdDistrictImpl") GenericFindByIdService<DistrictEntity, DistrictDto, Integer> findByIdService,
        @Qualifier("createDistrictImpl") CreateService<DistrictDto> createService,
        @Qualifier("updateDistrictImpl") UpdateService<DistrictDto, Integer> updateService,
        @Qualifier("deleteDistrictImpl") GenericDeleteService<DistrictEntity, DistrictDto, Integer> deleteService,
        @Qualifier("findAllDistrictByListIdsImpl") GenericFindAllByListIdsService<DistrictEntity, DistrictDto, Integer> findAllByListIdsService
    ) {
        this.findAllService = findAllService;
        this.findByIdService = findByIdService;
        this.createService = createService;
        this.updateService = updateService;
        this.deleteService = deleteService;
        this.findAllByListIdsService = findAllByListIdsService;
    }

    @Override
    public FindAllService<DistrictDto> getFindAllService() {
        return this.findAllService;
    }

    @Override
    public FindByIdService<DistrictDto, Integer> getFindByIdService() {
        return this.findByIdService;
    }

    @Override
    public CreateService<DistrictDto> getCreateService() {
        return this.createService;
    }

    @Override
    public UpdateService<DistrictDto, Integer> getUpdateService() {
        return this.updateService;
    }

    @Override
    public DeleteService<DistrictDto, Integer> getDeleteService() {
        return this.deleteService;
    }

    @Override
    public FindAllByListIdsService<DistrictDto, Integer> getFindAllByListIdsService() {
        return this.findAllByListIdsService;
    }

}