package com.ubigeo.core.controller;

import com.ubigeo.core.entity.DepartmentEntity;
import com.shared.core.controller.*;
import com.shared.core.service.*;
import com.shared.core.service.impl.*;
import com.shared.dto.DepartmentDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/departments")
public class DepartmentController implements FindAllController<DepartmentDto>, FindByIdController<DepartmentDto, Integer>, CreateController<DepartmentDto>, UpdateController<DepartmentDto, Integer>, DeleteController<DepartmentDto, Integer>, FindAllByListIdsController<DepartmentDto, Integer> {

    private final GenericFindAllService<DepartmentEntity, DepartmentDto, Integer> findAllService;
    private final GenericFindByIdService<DepartmentEntity, DepartmentDto, Integer> findByIdService;
    private final GenericCreateService<DepartmentEntity, DepartmentDto, Integer> createService;
    private final GenericUpdateService<DepartmentEntity, DepartmentDto, Integer> updateService;
    private final GenericDeleteService<DepartmentEntity, DepartmentDto, Integer> deleteService;
    private final GenericFindAllByListIdsService<DepartmentEntity, DepartmentDto, Integer> findAllByListIdsService;

    public DepartmentController(
            @Qualifier("findAllDepartmentImpl") GenericFindAllService<DepartmentEntity, DepartmentDto, Integer> findAllService,
            @Qualifier("findByIdDepartmentImpl") GenericFindByIdService<DepartmentEntity, DepartmentDto, Integer> findByIdService,
            @Qualifier("createDepartmentImpl") GenericCreateService<DepartmentEntity, DepartmentDto, Integer> createService,
            @Qualifier("updateDepartmentImpl") GenericUpdateService<DepartmentEntity, DepartmentDto, Integer> updateService,
            @Qualifier("deleteDepartmentImpl") GenericDeleteService<DepartmentEntity, DepartmentDto, Integer> deleteService,
            @Qualifier("findAllDepartmentByListIdsImpl") GenericFindAllByListIdsService<DepartmentEntity, DepartmentDto, Integer> findAllByListIdsService) {
        this.findAllService = findAllService;
        this.findByIdService = findByIdService;
        this.createService = createService;
        this.updateService = updateService;
        this.deleteService = deleteService;
        this.findAllByListIdsService = findAllByListIdsService;
    }

    @Override
    public FindAllService<DepartmentDto> getFindAllService() {
        return this.findAllService;
    }

    @Override
    public FindByIdService<DepartmentDto, Integer> getFindByIdService() {
        return this.findByIdService;
    }

    @Override
    public CreateService<DepartmentDto> getCreateService() {
        return this.createService;
    }

    @Override
    public UpdateService<DepartmentDto, Integer> getUpdateService() {
        return this.updateService;
    }

    @Override
    public DeleteService<DepartmentDto, Integer> getDeleteService() {
        return this.deleteService;
    }

    @Override
    public FindAllByListIdsService<DepartmentDto, Integer> getFindAllByListIdsService() {
        return this.findAllByListIdsService;
    }

}