package com.catalogs.core.controller;

import com.catalogs.core.controller.interfaces.IProductController;
import com.catalogs.core.entity.ProductEntity;
import com.shared.core.service.*;
import com.shared.core.service.impl.*;
import com.shared.dto.external.catalogs.ProductDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/products")
public class ProductController implements IProductController<ProductDto, Integer> {

    private final GenericFindAllService<ProductEntity, ProductDto, Integer> findAllService;
    private final GenericFindByIdService<ProductEntity, ProductDto, Integer> findByIdService;
    private final CreateService<ProductDto> createService;
    private final UpdateService<ProductDto, Integer> updateService;
    private final GenericDeleteService<ProductEntity, ProductDto, Integer> deleteService;
    private final GenericFindAllByListIdsService<ProductEntity, ProductDto, Integer> findAllByListIdsService;

    public ProductController(
            @Qualifier("findAllProductImpl") GenericFindAllService<ProductEntity, ProductDto, Integer> findAllService,
            @Qualifier("findByIdProductImpl") GenericFindByIdService<ProductEntity, ProductDto, Integer> findByIdService,
            @Qualifier("createProductImpl") CreateService<ProductDto> createService,
            @Qualifier("updateProductImpl") UpdateService<ProductDto, Integer> updateService,
            @Qualifier("deleteProductImpl") GenericDeleteService<ProductEntity, ProductDto, Integer> deleteService,
            @Qualifier("findAllProductByListIdsImpl") GenericFindAllByListIdsService<ProductEntity, ProductDto, Integer> findAllByListIdsService
    ) {
        this.findAllService = findAllService;
        this.findByIdService = findByIdService;
        this.createService = createService;
        this.updateService = updateService;
        this.deleteService = deleteService;
        this.findAllByListIdsService = findAllByListIdsService;
    }

    @Override
    public FindAllService<ProductDto> getFindAllService() {
        return this.findAllService;
    }

    @Override
    public FindByIdService<ProductDto, Integer> getFindByIdService() {
        return this.findByIdService;
    }

    @Override
    public CreateService<ProductDto> getCreateService() {
        return this.createService;
    }

    @Override
    public UpdateService<ProductDto, Integer> getUpdateService() {
        return this.updateService;
    }

    @Override
    public DeleteService<ProductDto, Integer> getDeleteService() {
        return this.deleteService;
    }

    @Override
    public FindAllByListIdsService<ProductDto, Integer> getFindAllByListIdsService() {
        return this.findAllByListIdsService;
    }

}