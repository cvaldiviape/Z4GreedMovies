package com.z4greed.core.rest.controller;

import com.z4greed.core.models.dto.CategoryProductDto;
import com.z4greed.core.models.entity.CategoryProductEntity;
import com.z4greed.core.rest.common.HandlerCrudController;
import com.z4greed.core.service.common.CrudService;
import com.z4greed.core.service.common.HandlerCrudService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/category-products")
public class CategoryProductController extends HandlerCrudController<CategoryProductDto, Integer> {

    private final HandlerCrudService<CategoryProductEntity, CategoryProductDto,Integer> categoryProductService;

    public CategoryProductController(@Qualifier("categoryProductServiceImpl")HandlerCrudService<CategoryProductEntity, CategoryProductDto,Integer> categoryProductService) {
        this.categoryProductService = categoryProductService;
    }

    @Override
    public CrudService<CategoryProductDto, Integer> getCrudService() {
        return this.categoryProductService;
    }

}