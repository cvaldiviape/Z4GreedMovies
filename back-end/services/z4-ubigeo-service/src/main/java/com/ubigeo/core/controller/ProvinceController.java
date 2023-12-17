package com.ubigeo.core.controller;

import com.ubigeo.core.entity.ProvinceEntity;
import com.shared.core.controller.*;
import com.shared.core.service.*;
import com.shared.core.service.impl.*;
import com.shared.dto.ProvinceDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/provinces")
public class ProvinceController implements FindAllController<ProvinceDto>, FindByIdController<ProvinceDto, Integer>, CreateController<ProvinceDto>, UpdateController<ProvinceDto, Integer>, DeleteController<ProvinceDto, Integer>, FindAllByListIdsController<ProvinceDto, Integer> {

    private final GenericFindAllService<ProvinceEntity, ProvinceDto, Integer> findAllService;
    private final GenericFindByIdService<ProvinceEntity, ProvinceDto, Integer> findByIdService;
    private final CreateService<ProvinceDto> createService;
    private final UpdateService<ProvinceDto, Integer> updateService;
    private final GenericDeleteService<ProvinceEntity, ProvinceDto, Integer> deleteService;
    private final GenericFindAllByListIdsService<ProvinceEntity, ProvinceDto, Integer> findAllByListIdsService;

    public ProvinceController(
            @Qualifier("findAllProvinceImpl") GenericFindAllService<ProvinceEntity, ProvinceDto, Integer> findAllService,
            @Qualifier("findByIdProvinceImpl") GenericFindByIdService<ProvinceEntity, ProvinceDto, Integer> findByIdService,
            @Qualifier("createProvinceImpl") CreateService<ProvinceDto> createService,
            @Qualifier("updateProvinceImpl") UpdateService<ProvinceDto, Integer> updateService,
            @Qualifier("deleteProvinceImpl") GenericDeleteService<ProvinceEntity, ProvinceDto, Integer> deleteService,
            @Qualifier("findAllProvinceByListIdsImpl") GenericFindAllByListIdsService<ProvinceEntity, ProvinceDto, Integer> findAllByListIdsService) {
        this.findAllService = findAllService;
        this.findByIdService = findByIdService;
        this.createService = createService;
        this.updateService = updateService;
        this.deleteService = deleteService;
        this.findAllByListIdsService = findAllByListIdsService;
    }

    @Override
    public FindAllService<ProvinceDto> getFindAllService() {
        return this.findAllService;
    }

    @Override
    public FindByIdService<ProvinceDto, Integer> getFindByIdService() {
        return this.findByIdService;
    }

    @Override
    public CreateService<ProvinceDto> getCreateService() {
        return this.createService;
    }

    @Override
    public UpdateService<ProvinceDto, Integer> getUpdateService() {
        return this.updateService;
    }

    @Override
    public DeleteService<ProvinceDto, Integer> getDeleteService() {
        return this.deleteService;
    }

    @Override
    public FindAllByListIdsService<ProvinceDto, Integer> getFindAllByListIdsService() {
        return this.findAllByListIdsService;
    }

}