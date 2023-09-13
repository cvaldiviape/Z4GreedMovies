package com.z4greed.core.rest.controller;

import com.z4greed.core.models.dto.CategoryProductDto;
import com.z4greed.core.models.dto.custom.ResponseDto;
import com.z4greed.core.models.entity.CategoryProductEntity;
import com.z4greed.core.rest.common.HandlerCrudController;
import com.z4greed.core.service.CategoryProductService;
import com.z4greed.core.service.common.CrudService;
import com.z4greed.core.service.common.HandlerCrudService;
import com.z4greed.shared.enums.ControllerMessageEnum;
import com.z4greed.shared.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

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

    @PostMapping("/getAllByListIds")
    public ResponseEntity<ResponseDto> getAllByListIds(@RequestBody Collection<Integer> listIds) {
        List<CategoryProductDto> result = this.categoryProductService.getAllByListIds(listIds);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.GET_ALL, result);
        return ResponseEntity.ok(response);
    }

}