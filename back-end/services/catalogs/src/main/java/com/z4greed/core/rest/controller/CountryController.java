package com.z4greed.core.rest.controller;

import com.z4greed.core.models.dto.CountryDto;
import com.z4greed.core.models.entity.CountryEntity;
import com.z4greed.core.rest.common.HandlerCrudController;
import com.z4greed.core.service.common.CrudService;
import com.z4greed.core.service.common.HandlerCrudService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/countries")
public class CountryController extends HandlerCrudController<CountryDto, Integer> {

    private final HandlerCrudService<CountryEntity, CountryDto,Integer> countryService;

    public CountryController(@Qualifier("countryServiceImpl")HandlerCrudService<CountryEntity, CountryDto, Integer> countryService) {
        this.countryService = countryService;
    }

    @Override
    public CrudService<CountryDto, Integer> getCrudService() {
        return this.countryService;
    }

}