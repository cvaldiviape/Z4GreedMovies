package com.z4greed.core.rest.controller;

import com.z4greed.core.models.dto.CategoryProductDto;
import com.z4greed.core.models.dto.base.BasePageDto;
import com.z4greed.core.models.dto.custom.ResponseDto;
import com.z4greed.core.service.CategoryProductService;
import com.z4greed.shared.constants.PageConstants;
import com.z4greed.shared.enums.ControllerMessageEnum;
import com.z4greed.shared.utils.ResponseUtil;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("category-product")
public class CategoryProductController {

    private final CategoryProductService categoryProductService;

    public CategoryProductController(CategoryProductService categoryProductService) {
        this.categoryProductService = categoryProductService;
    }

    @GetMapping
    public ResponseEntity<ResponseDto> getAll(@RequestParam(value = "numberPage", defaultValue = PageConstants.NUM_PAGE_DEFAULT, required = false) int numberPage,
                                              @RequestParam(value = "sizePage", defaultValue = PageConstants.SIZE_PAGE_DEFAULT, required = false) int sizePage,
                                              @RequestParam(value = "sortBy", defaultValue = PageConstants.SORT_BY_DEFAULT, required = false) String sortBy,
                                              @RequestParam(value = "sortDir", defaultValue = PageConstants.SORT_DIR_DEFAULT, required = false) String sortDir) {
        BasePageDto<CategoryProductDto> result = this.categoryProductService.getAll(numberPage, sizePage, sortBy, sortDir);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.GET_ALL, result);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getById(@PathVariable Integer id) {
        CategoryProductDto result = this.categoryProductService.getById(id);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.GET_BY_IO, result);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ResponseDto> create(@Valid @RequestBody CategoryProductDto dto) {
        CategoryProductDto result = this.categoryProductService.create(dto);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.CREATE, result);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> update(@PathVariable Integer id, @Valid @RequestBody CategoryProductDto dto ) {
        CategoryProductDto result = this.categoryProductService.update(id, dto);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.UPDATE, result);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable Integer id) {
        CategoryProductDto result = this.categoryProductService.delete(id);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.DELETE, result);
        return ResponseEntity.ok(response);
    }

}