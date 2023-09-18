package com.z4greed.core.service.impl;

import com.shared.dto.custom.BasePageDto;
import com.shared.dto.RoomDto;
import com.z4greed.core.service.RoomService;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {
    @Override
    public BasePageDto<RoomDto> findAll(Integer numberPage, Integer sizePage, String sortBy, String sortDir) {
        return null;
    }

    @Override
    public RoomDto findById(Integer integer) {
        return null;
    }

    @Override
    public RoomDto create(RoomDto roomDto) {
        return null;
    }

    @Override
    public RoomDto update(Integer integer, RoomDto roomDto) {
        return null;
    }

    @Override
    public RoomDto delete(Integer integer) {
        return null;
    }
}
