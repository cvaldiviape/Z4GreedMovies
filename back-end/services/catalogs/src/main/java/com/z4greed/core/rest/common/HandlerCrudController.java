package com.z4greed.core.rest.common;

import com.shared.constants.PageConstants;
import com.shared.dto.custom.BasePageDto;
import com.shared.enums.ControllerMessageEnum;
import com.shared.utils.response.ResponseDto;
import com.shared.utils.response.ResponseUtil;
import com.z4greed.core.service.common.CrudService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class HandlerCrudController<DTO, ID> {

    public abstract CrudService<DTO, ID> getCrudService();

    @GetMapping
    public ResponseEntity<ResponseDto> findAll(@RequestParam(value = "numberPage", defaultValue = PageConstants.NUM_PAGE_DEFAULT, required = false) Integer numberPage,
                                               @RequestParam(value = "sizePage", defaultValue = PageConstants.SIZE_PAGE_DEFAULT, required = false) Integer sizePage,
                                               @RequestParam(value = "sortBy", defaultValue = PageConstants.SORT_BY_DEFAULT, required = false) String sortBy,
                                               @RequestParam(value = "sortDir", defaultValue = PageConstants.SORT_DIR_DEFAULT, required = false) String sortDir) {
        BasePageDto<DTO> result = this.getCrudService().findAll(numberPage, sizePage, sortBy, sortDir);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.FIND_ALL, result);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findById(@PathVariable ID id) {
        DTO result = this.getCrudService().findById(id);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.FIND_BY_IO, result);
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