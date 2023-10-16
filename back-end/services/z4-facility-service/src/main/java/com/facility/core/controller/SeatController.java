package com.facility.core.controller;

import com.shared.constants.PageConstants;
import com.shared.dto.SeatDto;
import com.shared.dto.custom.BasePageDto;
import com.shared.enums.ControllerMessageEnum;
import com.shared.utils.response.ResponseDto;
import com.shared.utils.response.ResponseUtil;
import com.facility.core.service.SeatService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/seats")
public class SeatController {

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping
    public ResponseEntity<ResponseDto> findAll(@RequestParam(value = "numberPage", defaultValue = PageConstants.NUM_PAGE_DEFAULT, required = false) Integer numberPage,
                                               @RequestParam(value = "sizePage", defaultValue = PageConstants.SIZE_PAGE_DEFAULT, required = false) Integer sizePage,
                                               @RequestParam(value = "sortBy", defaultValue = PageConstants.SORT_BY_DEFAULT, required = false) String sortBy,
                                               @RequestParam(value = "sortDir", defaultValue = PageConstants.SORT_DIR_DEFAULT, required = false) String sortDir) {
        BasePageDto<SeatDto> result = this.seatService.findAll(numberPage, sizePage, sortBy, sortDir);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.FIND_ALL, result);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findById(@PathVariable Integer id) {
        SeatDto result = this.seatService.findById(id);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.FIND_BY_IO, result);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ResponseDto> create(@Valid @RequestBody SeatDto dto) {
        SeatDto result = this.seatService.create(dto);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.CREATE, result);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> update(@PathVariable Integer id, @Valid @RequestBody SeatDto dto) {
        SeatDto result = this.seatService.update(id, dto);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.UPDATE, result);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable Integer id) {
        SeatDto result = this.seatService.delete(id);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.DELETE, result);
        return ResponseEntity.ok(response);
    }

}