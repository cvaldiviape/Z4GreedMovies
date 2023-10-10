package com.z4greed.core.service.impl;

import com.shared.dto.custom.BasePageDto;
import com.shared.dto.SeatDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.PageUtil;
import com.shared.utils.ValidateUtil;
import com.z4greed.core.entity.RoomEntity;
import com.z4greed.core.entity.SeatEntity;
import com.z4greed.core.entity.mapper.SeatMapper;
import com.z4greed.core.repositories.RoomRespository;
import com.z4greed.core.repositories.SeatRepository;
import com.z4greed.core.service.SeatService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;
    private final RoomRespository roomRespository;
    private final SeatMapper seatMapper;

    public SeatServiceImpl(SeatRepository seatRepository, RoomRespository roomRespository, SeatMapper seatMapper) {
        this.seatRepository = seatRepository;
        this.roomRespository = roomRespository;
        this.seatMapper = seatMapper;
    }

    @Override
    public BasePageDto<SeatDto> findAll(Integer numberPage, Integer sizePage, String sortBy, String sortDir) {
        Pageable pageable = PageUtil.getPageable(numberPage, sizePage, sortBy, sortDir);
        Page<SeatEntity> pageData = this.seatRepository.findAll(pageable);
        List<SeatEntity> listEntities = pageData.getContent();

        List<SeatDto> listSeats = this.seatMapper.toListDtos(listEntities);

        return BasePageDto.<SeatDto>builder()
                .listElements(listSeats)
                .numberPage(pageData.getNumber())
                .sizePage(pageData.getSize())
                .totalElements(pageData.getTotalElements())
                .totalPages(pageData.getTotalPages())
                .isLastPage(pageData.isLast())
                .build();
    }

    @Override
    public SeatDto findById(Integer id) {
        SeatEntity entity = this.findSeatEntityById(id);
        return this.seatMapper.toDto(entity);
    }

    @Override
    public SeatDto create(SeatDto seatDto) {
        this.validateUniqueFields(seatDto);
        SeatEntity seatEntity = this.seatMapper.toEntity(seatDto);

        RoomEntity roomEntity = this.findRoomEntityById(seatDto.getRoom().getIdRoom());
        seatEntity.setRoom(roomEntity);

        SeatEntity seatCreated = this.seatRepository.save(seatEntity);
        return this.seatMapper.toDto(seatCreated);
    }

    @Override
    public SeatDto update(Integer id, SeatDto seatDto) {
        SeatEntity seatEntity = this.findSeatEntityById(id);
        this.validateUniqueFields(id, seatDto);

        this.seatMapper.updateEntityFromDto(seatDto, seatEntity);

        RoomEntity roomEntity = this.findRoomEntityById(seatDto.getRoom().getIdRoom());
        seatEntity.setRoom(roomEntity);

        SeatEntity roomUpdated = this.seatRepository.save(seatEntity);
        return this.seatMapper.toDto(roomUpdated);
    }

    @Override
    public SeatDto delete(Integer id) {
        SeatEntity seatEntity = this.findSeatEntityById(id);
        this.seatRepository.delete(seatEntity);
        return this.seatMapper.toDto(seatEntity);
    }

    // ------------------------------------------------------------------------- utils ------------------------------------------------------------------------- //
    public SeatEntity findSeatEntityById(Integer idSeat) {
        return this.seatRepository.findById(idSeat)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.SEAT.getValue(), idSeat));
    }

    private RoomEntity findRoomEntityById(Integer idRoom) {
        return this.roomRespository.findById(idRoom)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.ROOM.getValue(), idRoom));
    }

    public void validateUniqueFields(SeatDto seatDto) {
        Boolean existsCode = this.seatRepository.existsByCode(seatDto.getCode());
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, seatDto.getCode());
    }

    public void validateUniqueFields(Integer id, SeatDto seatDto) {
        Boolean existsCode = this.seatRepository.existsByCodeAndIdSeatNot(seatDto.getCode(), id);
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, seatDto.getCode());
    }

}