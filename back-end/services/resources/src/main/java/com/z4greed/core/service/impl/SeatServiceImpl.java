package com.z4greed.core.service.impl;

import com.shared.dto.custom.BasePageDto;
import com.shared.dto.SeatDto;
import com.z4greed.core.service.SeatService;
import org.springframework.stereotype.Service;

@Service
public class SeatServiceImpl implements SeatService {
    @Override
    public BasePageDto<SeatDto> findAll(Integer numberPage, Integer sizePage, String sortBy, String sortDir) {
        return null;
    }

    @Override
    public SeatDto findById(Integer integer) {
        return null;
    }

    @Override
    public SeatDto create(SeatDto seatDto) {
        return null;
    }

    @Override
    public SeatDto update(Integer integer, SeatDto seatDto) {
        return null;
    }

    @Override
    public SeatDto delete(Integer integer) {
        return null;
    }
}
