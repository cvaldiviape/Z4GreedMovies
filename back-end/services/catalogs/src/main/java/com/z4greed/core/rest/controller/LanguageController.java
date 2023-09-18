package com.z4greed.core.rest.controller;

import com.shared.dto.LanguageDto;
import com.shared.enums.ControllerMessageEnum;
import com.shared.utils.response.ResponseDto;
import com.shared.utils.response.ResponseUtil;
import com.z4greed.core.models.entity.LanguageEntity;
import com.z4greed.core.rest.common.HandlerCrudController;
import com.z4greed.core.service.LanguageService;
import com.z4greed.core.service.common.CrudService;
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

    @PostMapping("/findAllByListIds")
    public ResponseEntity<ResponseDto> findAllByListIds(@RequestBody Collection<Integer> listIds) {
        List<LanguageDto> result = this.languageService.findAllByListIds(listIds);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.FIND_ALL, result);
        return ResponseEntity.ok(response);
    }

}