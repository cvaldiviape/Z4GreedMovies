package com.z4greed.core.rest.controller;

import com.z4greed.core.models.dto.LanguageDto;
import com.z4greed.core.models.dto.custom.ResponseDto;
import com.z4greed.core.models.entity.LanguageEntity;
import com.z4greed.core.rest.common.HandlerCrudController;
import com.z4greed.core.service.LanguageService;
import com.z4greed.core.service.common.CrudService;
import com.z4greed.core.service.common.HandlerCrudService;
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
@RequestMapping("api/languages")
public class LanguageController extends HandlerCrudController<LanguageDto, Integer> {

    private final LanguageService<LanguageEntity, LanguageDto, Integer> languageService;

    public LanguageController(@Qualifier("languageServiceImpl")LanguageService<LanguageEntity, LanguageDto, Integer> languageService) {
        this.languageService = languageService;
    }

    @Override
    public CrudService<LanguageDto, Integer> getCrudService() {
        return this.languageService;
    }

    @PostMapping("/getAllByListIds")
    public ResponseEntity<ResponseDto> getAllByListIds(@RequestBody Collection<Integer> listIds) {
        List<LanguageDto> result = this.languageService.getAllByListIds(listIds);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.GET_ALL, result);
        return ResponseEntity.ok(response);
    }

}