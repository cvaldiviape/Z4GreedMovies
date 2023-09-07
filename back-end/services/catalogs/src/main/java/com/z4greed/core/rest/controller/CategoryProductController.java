package com.z4greed.core.rest.controller;

import com.z4greed.core.models.dto.CategoryProductDto;
import com.z4greed.core.models.common.BasePageDto;
import com.z4greed.core.rest.common.HandlerCrudController;
import com.z4greed.core.service.CategoryProductService;
import com.z4greed.core.service.common.CrudService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/category-products")
public class CategoryProductController extends HandlerCrudController<CategoryProductDto, Integer> {

    private final CategoryProductService categoryProductService;

    public CategoryProductController(CategoryProductService categoryProductService) {
        this.categoryProductService = categoryProductService;
    }

    @Override
    public CrudService<CategoryProductDto, Integer> getCrudService() {
        return categoryProductService;
    }

}