package com.z4greed.core.rest.common;

import com.z4greed.core.models.common.BaseDto;
import com.z4greed.core.models.common.BasePageDto;
import com.z4greed.core.models.dto.custom.ResponseDto;
import com.z4greed.core.service.common.CrudService;
import com.z4greed.shared.constants.PageConstants;
import com.z4greed.shared.enums.ControllerMessageEnum;
import com.z4greed.shared.utils.ResponseUtil;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.List;

public abstract class HandlerCrudController<DTO extends BaseDto, ID> {

    public abstract CrudService<DTO, ID> getCrudService();

    @GetMapping
    public ResponseEntity<ResponseDto> getAll(@RequestParam(value = "numberPage", defaultValue = PageConstants.NUM_PAGE_DEFAULT, required = false) Integer numberPage,
                                              @RequestParam(value = "sizePage", defaultValue = PageConstants.SIZE_PAGE_DEFAULT, required = false) Integer sizePage,
                                              @RequestParam(value = "sortBy", defaultValue = PageConstants.SORT_BY_DEFAULT, required = false) String sortBy,
                                              @RequestParam(value = "sortDir", defaultValue = PageConstants.SORT_DIR_DEFAULT, required = false) String sortDir) {
        BasePageDto<DTO> result = this.getCrudService().getAll(numberPage, sizePage, sortBy, sortDir);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.GET_ALL, result);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getById(@PathVariable ID id) {
        DTO result = this.getCrudService().getById(id);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.GET_BY_IO, result);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ResponseDto> create(@Valid @RequestBody DTO dto) {
        DTO result = this.getCrudService().create(dto);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.CREATE, result);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> update(@PathVariable ID id, @Valid @RequestBody DTO dto ) {
        DTO result = this.getCrudService().update(id, dto);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.UPDATE, result);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable ID id) {
        DTO result = this.getCrudService().delete(id);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.DELETE, result);
        return ResponseEntity.ok(response);
    }

}