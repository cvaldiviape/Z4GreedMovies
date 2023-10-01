package com.z4greed.core.controller;

import com.shared.dto.CategoryProductDto;
import com.shared.enums.ControllerMessageEnum;
import com.shared.utils.response.ResponseDto;
import com.shared.utils.response.ResponseUtil;
import com.z4greed.core.models.entity.CategoryProductEntity;
import com.z4greed.core.controller.common.HandlerCrudController;
import com.z4greed.core.service.CategoryProductService;
import com.z4greed.core.service.common.CrudService;
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

    @PostMapping("/findAllByListIds")
    public ResponseEntity<ResponseDto> findAllByListIds(@RequestBody Collection<Integer> listIds) {
        List<CategoryProductDto> result = this.categoryProductService.findAllByListIds(listIds);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.FIND_ALL, result);
        return ResponseEntity.ok(response);
    }

}