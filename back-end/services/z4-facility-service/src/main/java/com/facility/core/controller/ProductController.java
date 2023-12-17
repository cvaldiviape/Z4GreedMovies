package com.facility.core.controller;

import com.shared.constants.PageConstants;
import com.shared.dto.custom.BasePageDto;
import com.shared.dto.external.catalogs.ProductDto;
import com.shared.utils.response.ResponseDto;
import com.shared.enums.ControllerMessageEnum;
import com.shared.utils.response.ResponseUtil;
import com.facility.core.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<ResponseDto> findAll(@RequestParam(value = "numberPage", defaultValue = PageConstants.NUM_PAGE_DEFAULT, required = false) Integer numberPage,
                                               @RequestParam(value = "sizePage", defaultValue = PageConstants.SIZE_PAGE_DEFAULT, required = false) Integer sizePage,
                                               @RequestParam(value = "sortBy", defaultValue = PageConstants.SORT_BY_DEFAULT, required = false) String sortBy,
                                               @RequestParam(value = "sortDir", defaultValue = PageConstants.SORT_DIR_DEFAULT, required = false) String sortDir) {
        BasePageDto<ProductDto> result = this.productService.findAll(numberPage, sizePage, sortBy, sortDir);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.FIND_ALL, result);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findById(@PathVariable Integer id) {
        ProductDto result = this.productService.findById(id);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.FIND_BY_IO, result);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ResponseDto> create(@Valid @RequestBody ProductDto dto) {
        ProductDto result = this.productService.create(dto);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.CREATE, result);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> update(@PathVariable Integer id, @Valid @RequestBody ProductDto dto ) {
        ProductDto result = this.productService.update(id, dto);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.UPDATE, result);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable Integer id) {
        ProductDto result = this.productService.delete(id);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.DELETE, result);
        return ResponseEntity.ok(response);
    }

}
