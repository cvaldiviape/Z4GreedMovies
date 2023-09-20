package com.z4greed.core.service.impl;

import com.shared.dto.CountryDto;
import com.shared.dto.custom.BasePageDto;
import com.shared.dto.RoomDto;
import com.shared.enums.ValueEnum;
import com.shared.error.GeneralErrorEnum;
import com.shared.utils.PageUtil;
import com.shared.utils.ValidateUtil;
import com.z4greed.core.model.entity.RoomEntity;
import com.z4greed.core.model.mapper.RoomMapper;
import com.z4greed.core.repositories.RoomRespository;
import com.z4greed.core.service.RoomService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRespository roomRespository;
    private final RoomMapper roomMapper;

    public RoomServiceImpl(RoomRespository roomRespository, RoomMapper roomMapper) {
        this.roomRespository = roomRespository;
        this.roomMapper = roomMapper;
    }

    @Override
    public BasePageDto<RoomDto> findAll(Integer numberPage, Integer sizePage, String sortBy, String sortDir) {
        Pageable pageable = PageUtil.getPageable(numberPage, sizePage, sortBy, sortDir);
        Page<RoomEntity> pageData = this.roomRespository.findAll(pageable);
        List<RoomEntity> listEntities = pageData.getContent();

        List<RoomDto> listRooms = this.roomMapper.toListDtos(listEntities);

        return BasePageDto.<RoomDto>builder()
                .listElements(listRooms)
                .numberPage(pageData.getNumber())
                .sizePage(pageData.getSize())
                .totalElements(pageData.getTotalElements())
                .totalPages(pageData.getTotalPages())
                .isLastPage(pageData.isLast())
                .build();
    }

    @Override
    public RoomDto findById(Integer id) {
        RoomEntity entity = this.findEntityById(id);
        return this.roomMapper.toDto(entity);
    }

    @Override
    public RoomDto create(RoomDto roomDto) {
        this.verifyUnique(roomDto);
        RoomEntity roomEntity = this.roomMapper.toEntity(roomDto);
        RoomEntity roomCreated = this.roomRespository.save(roomEntity);
        return this.roomMapper.toDto(roomCreated);
    }

    @Override
    public RoomDto update(Integer id, RoomDto roomDto) {
        RoomEntity roomEntity = this.findEntityById(id);
        this.verifyUnique(id, roomDto);
        this.roomMapper.updateEntityFromDto(roomDto, roomEntity);
        RoomEntity roomUpdated = this.roomRespository.save(roomEntity);
        return this.roomMapper.toDto(roomUpdated);
    }

    @Override
    public RoomDto delete(Integer id) {
        RoomEntity roomEntity = this.findEntityById(id);
        this.roomRespository.delete(roomEntity);
        return this.roomMapper.toDto(roomEntity);
    }

    // ------------------------------------------------------------------------- utils ------------------------------------------------------------------------- //
    public RoomEntity findEntityById(Integer id) {
        return this.roomRespository.findById(id)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.ROOM.getValue(), id));
    }

    public void verifyUnique(RoomDto dto) {
        Boolean existsCode = this.roomRespository.existsByCode(dto.getCode());
        ValidateUtil.evaluateTrue(existsCode, GeneralErrorEnum.ER000005, ValueEnum.CODE.getValue(), dto.getCode());
    }

    public void verifyUnique(Integer id, RoomDto dto) {
        Boolean existsCode = this.roomRespository.existsByCodeAndIdRoomNot(dto.getCode(), id);
        ValidateUtil.evaluateTrue(existsCode, GeneralErrorEnum.ER000005, ValueEnum.CODE.getValue(), dto.getCode());
    }

}