package com.catalogs.core.controller;

import com.catalogs.core.entity.CategoryProductEntity;
import com.shared.core.controller.*;
import com.shared.core.service.*;
import com.shared.core.service.impl.*;
import com.shared.dto.external.catalogs.CategoryProductDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/category-products")
public class CategoryProductController implements FindAllController<CategoryProductDto>, FindByIdController<CategoryProductDto, Integer>, CreateController<CategoryProductDto>, UpdateController<CategoryProductDto, Integer>, DeleteController<CategoryProductDto, Integer>, FindAllByListIdsController<CategoryProductDto, Integer> {

    private final GenericFindAllService<CategoryProductEntity, CategoryProductDto, Integer> findAllService;
    private final GenericFindByIdService<CategoryProductEntity, CategoryProductDto, Integer> findByIdService;
    private final GenericCreateService<CategoryProductEntity, CategoryProductDto, Integer> createService;
    private final GenericUpdateService<CategoryProductEntity, CategoryProductDto, Integer> updateService;
    private final GenericDeleteService<CategoryProductEntity, CategoryProductDto, Integer> deleteService;
    private final GenericFindAllByListIdsService<CategoryProductEntity, CategoryProductDto, Integer> findAllByListIdsService;

    public CategoryProductController(
            @Qualifier("findAllCategoryProductImpl") GenericFindAllService<CategoryProductEntity, CategoryProductDto, Integer> findAllService,
            @Qualifier("findByIdCategoryProductImpl") GenericFindByIdService<CategoryProductEntity, CategoryProductDto, Integer> findByIdService,
            @Qualifier("createCategoryProductImpl") GenericCreateService<CategoryProductEntity, CategoryProductDto, Integer> createService,
            @Qualifier("updateCategoryProductImpl") GenericUpdateService<CategoryProductEntity, CategoryProductDto, Integer> updateService,
            @Qualifier("deleteCategoryProductImpl") GenericDeleteService<CategoryProductEntity, CategoryProductDto, Integer> deleteService,
            @Qualifier("findAllCategoryProductByListIdsImpl") GenericFindAllByListIdsService<CategoryProductEntity, CategoryProductDto, Integer> findAllByListIdsService) {
        this.findAllService = findAllService;
        this.findByIdService = findByIdService;
        this.createService = createService;
        this.updateService = updateService;
        this.deleteService = deleteService;
        this.findAllByListIdsService = findAllByListIdsService;
    }

    @Override
    public FindAllService<CategoryProductDto> getFindAllService() {
        return this.findAllService;
    }

    @Override
    public FindByIdService<CategoryProductDto, Integer> getFindByIdService() {
        return this.findByIdService;
    }

    @Override
    public CreateService<CategoryProductDto> getCreateService() {
        return this.createService;
    }

    @Override
    public UpdateService<CategoryProductDto, Integer> getUpdateService() {
        return this.updateService;
    }

    @Override
    public DeleteService<CategoryProductDto, Integer> getDeleteService() {
        return this.deleteService;
    }

    @Override
    public FindAllByListIdsService<CategoryProductDto, Integer> getFindAllByListIdsService() {
        return this.findAllByListIdsService;
    }

}