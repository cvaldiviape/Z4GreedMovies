package com.facility.core.controller;

import com.facility.core.entity.RoomEntity;
import com.shared.core.controller.*;
import com.shared.core.service.*;
import com.shared.core.service.impl.*;
import com.shared.dto.external.facility.RoomDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/rooms")
public class RoomController implements FindAllController<RoomDto>, FindByIdController<RoomDto, Integer>, CreateController<RoomDto>, UpdateController<RoomDto, Integer>, DeleteController<RoomDto, Integer>, FindAllByListIdsController<RoomDto, Integer> {

    private final GenericFindAllService<RoomEntity, RoomDto, Integer> findAllService;
    private final GenericFindByIdService<RoomEntity, RoomDto, Integer> findByIdService;
    private final CreateService<RoomDto> createService;
    private final GenericUpdateService<RoomEntity, RoomDto, Integer> updateService;
    private final GenericDeleteService<RoomEntity, RoomDto, Integer> deleteService;
    private final GenericFindAllByListIdsService<RoomEntity, RoomDto, Integer> findAllByListIdsService;

    public RoomController(
        @Qualifier("findAllRoomImpl") GenericFindAllService<RoomEntity, RoomDto, Integer> findAllService,
        @Qualifier("findByIdRoomImpl") GenericFindByIdService<RoomEntity, RoomDto, Integer> findByIdService,
        @Qualifier("createRoomImpl") CreateService<RoomDto> createService,
        @Qualifier("updateRoomImpl") GenericUpdateService<RoomEntity, RoomDto, Integer> updateService,
        @Qualifier("deleteRoomImpl") GenericDeleteService<RoomEntity, RoomDto, Integer> deleteService,
        @Qualifier("findAllRoomByListIdsImpl") GenericFindAllByListIdsService<RoomEntity, RoomDto, Integer> findAllByListIdsService) {
        this.findAllService = findAllService;
        this.findByIdService = findByIdService;
        this.createService = createService;
        this.updateService = updateService;
        this.deleteService = deleteService;
        this.findAllByListIdsService = findAllByListIdsService;
    }

    @Override
    public FindAllService<RoomDto> getFindAllService() {
        return this.findAllService;
    }

    @Override
    public FindByIdService<RoomDto, Integer> getFindByIdService() {
        return this.findByIdService;
    }

    @Override
    public CreateService<RoomDto> getCreateService() {
        return this.createService;
    }

    @Override
    public UpdateService<RoomDto, Integer> getUpdateService() {
        return this.updateService;
    }

    @Override
    public DeleteService<RoomDto, Integer> getDeleteService() {
        return this.deleteService;
    }

    @Override
    public FindAllByListIdsService<RoomDto, Integer> getFindAllByListIdsService() {
        return this.findAllByListIdsService;
    }

}