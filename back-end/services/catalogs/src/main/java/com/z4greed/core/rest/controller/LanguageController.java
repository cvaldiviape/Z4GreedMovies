package com.z4greed.core.rest.controller;

import com.z4greed.core.models.dto.LanguageDto;
import com.z4greed.core.models.entity.LanguageEntity;
import com.z4greed.core.rest.common.HandlerCrudController;
import com.z4greed.core.service.common.CrudService;
import com.z4greed.core.service.common.HandlerCrudService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/languages")
public class LanguageController extends HandlerCrudController<LanguageDto, Integer> {

    private final HandlerCrudService<LanguageEntity, LanguageDto, Integer> languageService;

    public LanguageController(@Qualifier("languageServiceImpl")HandlerCrudService<LanguageEntity, LanguageDto, Integer> languageService) {
        this.languageService = languageService;
    }

    @Override
    public CrudService<LanguageDto, Integer> getCrudService() {
        return this.languageService;
    }

}