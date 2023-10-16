package com.facility.core.controller;

import com.shared.constants.PageConstants;
import com.shared.dto.RoomDto;
import com.shared.dto.custom.BasePageDto;
import com.shared.enums.ControllerMessageEnum;
import com.shared.utils.response.ResponseDto;
import com.shared.utils.response.ResponseUtil;
import com.facility.core.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public ResponseEntity<ResponseDto> findAll(@RequestParam(value = "numberPage", defaultValue = PageConstants.NUM_PAGE_DEFAULT, required = false) Integer numberPage,
                                               @RequestParam(value = "sizePage", defaultValue = PageConstants.SIZE_PAGE_DEFAULT, required = false) Integer sizePage,
                                               @RequestParam(value = "sortBy", defaultValue = PageConstants.SORT_BY_DEFAULT, required = false) String sortBy,
                                               @RequestParam(value = "sortDir", defaultValue = PageConstants.SORT_DIR_DEFAULT, required = false) String sortDir) {
        BasePageDto<RoomDto> result = this.roomService.findAll(numberPage, sizePage, sortBy, sortDir);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.FIND_ALL, result);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findById(@PathVariable Integer id) {
        RoomDto result = this.roomService.findById(id);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.FIND_BY_IO, result);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ResponseDto> create(@Valid @RequestBody RoomDto dto) {
        RoomDto result = this.roomService.create(dto);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.CREATE, result);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> update(@PathVariable Integer id, @Valid @RequestBody RoomDto dto) {
        RoomDto result = this.roomService.update(id, dto);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.UPDATE, result);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable Integer id) {
        RoomDto result = this.roomService.delete(id);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.DELETE, result);
        return ResponseEntity.ok(response);
    }

}