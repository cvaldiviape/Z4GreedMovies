package com.z4greed.core.rest.controller;

import com.z4greed.core.models.dto.CountryDto;
import com.z4greed.core.models.dto.custom.ResponseDto;
import com.z4greed.core.models.entity.CountryEntity;
import com.z4greed.core.rest.common.HandlerCrudController;
import com.z4greed.core.service.CountryService;
import com.z4greed.core.service.common.CrudService;
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
@RequestMapping("api/countries")
public class CountryController extends HandlerCrudController<CountryDto, Integer> {

    private final CountryService<CountryEntity, CountryDto,Integer> countryService;

    public CountryController(@Qualifier("countryServiceImpl")CountryService<CountryEntity, CountryDto, Integer> countryService) {
        this.countryService = countryService;
    }

    @Override
    public CrudService<CountryDto, Integer> getCrudService() {
        return this.countryService;
    }

    @PostMapping("/findAllByListIds")
    public ResponseEntity<ResponseDto> findAllByListIds(@RequestBody Collection<Integer> listIds) {
        List<CountryDto> result = this.countryService.findAllByListIds(listIds);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.GET_ALL, result);
        return ResponseEntity.ok(response);
    }

}