package com.facility.core.controller;

import com.facility.core.controller.interfaces.IEstablishmentController;
import com.facility.core.entity.EstablishmentEntity;
import com.shared.core.controller.*;
import com.shared.core.service.*;
import com.shared.core.service.impl.*;
import com.shared.dto.external.facility.EstablishmentDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/establishment")
public class EstablishmentController implements IEstablishmentController<EstablishmentDto, Integer> {

    private final GenericFindAllService<EstablishmentEntity, EstablishmentDto, Integer> findAllService;
    private final GenericFindByIdService<EstablishmentEntity, EstablishmentDto, Integer> findByIdService;
    private final GenericCreateService<EstablishmentEntity, EstablishmentDto, Integer> createService;
    private final GenericUpdateService<EstablishmentEntity, EstablishmentDto, Integer> updateService;
    private final GenericDeleteService<EstablishmentEntity, EstablishmentDto, Integer> deleteService;
    private final GenericFindAllByListIdsService<EstablishmentEntity, EstablishmentDto, Integer> findAllByListIdsService;

    public EstablishmentController(
        @Qualifier("findAllEstablishmentImpl") GenericFindAllService<EstablishmentEntity, EstablishmentDto, Integer> findAllService,
        @Qualifier("findByIdEstablishmentImpl") GenericFindByIdService<EstablishmentEntity, EstablishmentDto, Integer> findByIdService,
        @Qualifier("createEstablishmentImpl") GenericCreateService<EstablishmentEntity, EstablishmentDto, Integer> createService,
        @Qualifier("updateEstablishmentImpl") GenericUpdateService<EstablishmentEntity, EstablishmentDto, Integer> updateService,
        @Qualifier("deleteEstablishmentImpl") GenericDeleteService<EstablishmentEntity, EstablishmentDto, Integer> deleteService,
        @Qualifier("findAllEstablishmentByListIdsImpl") GenericFindAllByListIdsService<EstablishmentEntity, EstablishmentDto, Integer> findAllByListIdsService) {
        this.findAllService = findAllService;
        this.findByIdService = findByIdService;
        this.createService = createService;
        this.updateService = updateService;
        this.deleteService = deleteService;
        this.findAllByListIdsService = findAllByListIdsService;
    }

    @Override
    public FindAllService<EstablishmentDto> getFindAllService() {
        return this.findAllService;
    }

    @Override
    public FindByIdService<EstablishmentDto, Integer> getFindByIdService() {
        return this.findByIdService;
    }

    @Override
    public CreateService<EstablishmentDto> getCreateService() {
        return this.createService;
    }

    @Override
    public UpdateService<EstablishmentDto, Integer> getUpdateService() {
        return this.updateService;
    }

    @Override
    public DeleteService<EstablishmentDto, Integer> getDeleteService() {
        return this.deleteService;
    }

    @Override
    public FindAllByListIdsService<EstablishmentDto, Integer> getFindAllByListIdsService() {
        return this.findAllByListIdsService;
    }

}