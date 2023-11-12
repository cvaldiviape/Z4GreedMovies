package com.catalogs.core.controller;

import com.shared.core.controller.old.HandlerCrudController;
import com.shared.core.service.old.CrudService;
import com.shared.dto.CategoryProductDto;
import com.shared.enums.ControllerMessageEnum;
import com.shared.utils.response.ResponseDto;
import com.shared.utils.response.ResponseUtil;
import com.catalogs.core.entity.CategoryProductEntity;
import com.catalogs.core.service.CategoryProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("api/category-products")
public class CategoryProductController extends HandlerCrudController<CategoryProductDto, Integer> {

    private final CategoryProductService<CategoryProductEntity, CategoryProductDto,Integer> categoryProductService;

    public CategoryProductController(@Qualifier("categoryProductServiceImpl")CategoryProductService<CategoryProductEntity, CategoryProductDto,Integer> categoryProductService) {
        this.categoryProductService = categoryProductService;
    }

    @Override
    public CrudService<CategoryProductDto, Integer> getCrudService() {
        return this.categoryProductService;
    }

    @PostMapping("/findAllByListIds")
    public ResponseEntity<ResponseDto> findAllByListIds(@RequestBody Collection<Integer> listIds) {
        Collection<CategoryProductDto> result = this.categoryProductService.findAllByListIds(listIds);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.FIND_ALL, result);
        return ResponseEntity.ok(response);
    }

}