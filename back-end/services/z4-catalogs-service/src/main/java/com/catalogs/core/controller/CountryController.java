package com.catalogs.core.controller;

import com.shared.core.controller.HandlerCrudController;
import com.shared.core.service.CrudService;
import com.shared.dto.CountryDto;
import com.shared.enums.ControllerMessageEnum;
import com.shared.utils.response.ResponseDto;
import com.shared.utils.response.ResponseUtil;
import com.catalogs.core.entity.CountryEntity;
import com.catalogs.core.service.CountryService;
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
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.FIND_ALL, result);
        return ResponseEntity.ok(response);
    }

}