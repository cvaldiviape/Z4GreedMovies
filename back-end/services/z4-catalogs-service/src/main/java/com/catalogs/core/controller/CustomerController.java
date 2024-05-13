package com.catalogs.core.controller;

import com.catalogs.core.controller.interfaces.ICustomerController;
import com.catalogs.core.entity.CustomerEntity;
import com.shared.core.service.*;
import com.shared.core.service.impl.*;
import com.shared.dto.external.catalogs.CustomerDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/customers")
public class CustomerController implements ICustomerController<CustomerDto, Integer> {

    private final GenericFindAllService<CustomerEntity, CustomerDto, Integer> findAllService;
    private final GenericFindByIdService<CustomerEntity, CustomerDto, Integer> findByIdService;
    private final GenericCreateService<CustomerEntity, CustomerDto, Integer> createService;
    private final GenericUpdateService<CustomerEntity, CustomerDto, Integer> updateService;
    private final GenericDeleteService<CustomerEntity, CustomerDto, Integer> deleteService;
    private final GenericFindAllByListIdsService<CustomerEntity, CustomerDto, Integer> findAllByListIdsService;

    public CustomerController(
            @Qualifier("findAllCustomerImpl") GenericFindAllService<CustomerEntity, CustomerDto, Integer> findAllService,
            @Qualifier("findByIdCustomerImpl") GenericFindByIdService<CustomerEntity, CustomerDto, Integer> findByIdService,
            @Qualifier("createCustomerImpl") GenericCreateService<CustomerEntity, CustomerDto, Integer> createService,
            @Qualifier("updateCustomerImpl") GenericUpdateService<CustomerEntity, CustomerDto, Integer> updateService,
            @Qualifier("deleteCustomerImpl")  GenericDeleteService<CustomerEntity, CustomerDto, Integer> deleteService,
            @Qualifier("findAllCustomerByListIdsImpl") GenericFindAllByListIdsService<CustomerEntity, CustomerDto, Integer> findAllByListIdsService) {
        this.findAllService = findAllService;
        this.findByIdService = findByIdService;
        this.createService = createService;
        this.updateService = updateService;
        this.deleteService = deleteService;
        this.findAllByListIdsService = findAllByListIdsService;
    }

    @Override
    public FindAllService<CustomerDto> getFindAllService() {
        return this.findAllService;
    }

    @Override
    public FindByIdService<CustomerDto, Integer> getFindByIdService() {
        return this.findByIdService;
    }

    @Override
    public CreateService<CustomerDto> getCreateService() {
        return this.createService;
    }

    @Override
    public UpdateService<CustomerDto, Integer> getUpdateService() {
        return this.updateService;
    }

    @Override
    public DeleteService<CustomerDto, Integer> getDeleteService() {
        return this.deleteService;
    }

    @Override
    public FindAllByListIdsService<CustomerDto, Integer> getFindAllByListIdsService() {
        return this.findAllByListIdsService;
    }

}