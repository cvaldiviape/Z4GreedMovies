package com.z4greed.core.rest.controller;

import com.z4greed.core.models.dto.CategoryProductDto;
import com.z4greed.core.models.common.BasePageDto;
import com.z4greed.core.models.dto.custom.ResponseDto;
import com.z4greed.core.rest.common.CrudController;
import com.z4greed.core.service.CategoryProductService;
import com.z4greed.core.service.common.CrudService;
import com.z4greed.shared.constants.PageConstants;
import com.z4greed.shared.enums.ControllerMessageEnum;
import com.z4greed.shared.utils.ResponseUtil;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/category-products")
public class CategoryProductController extends CrudController<BasePageDto<CategoryProductDto>, CategoryProductDto, Integer> {

    private final CategoryProductService categoryProductService;

    public CategoryProductController(CategoryProductService categoryProductService) {
        this.categoryProductService = categoryProductService;
    }

    @Override
    public CrudService<BasePageDto<CategoryProductDto>, CategoryProductDto, Integer> getCrudService() {
        return categoryProductService;
    }

}