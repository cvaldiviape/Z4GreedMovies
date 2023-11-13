package com.catalogs.core.controller;

import com.catalogs.core.entity.AudienceEntity;
import com.shared.core.controller.old.HandlerCrudController;
import com.shared.core.service.old.CrudService;
import com.shared.dto.AudienceDto;
import com.shared.enums.ControllerMessageEnum;
import com.shared.utils.response.ResponseDto;
import com.shared.utils.response.ResponseUtil;
import com.catalogs.core.service.AudienceService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("api/audiences")
public class AudienceController extends HandlerCrudController<AudienceDto, Integer> {

    private final AudienceService<AudienceEntity, AudienceDto, Integer> audienceService;

    public AudienceController(@Qualifier("audienceServiceImpl") AudienceService<AudienceEntity, AudienceDto, Integer> audienceService) {
        this.audienceService = audienceService;
    }

    @Override
    public CrudService<AudienceDto, Integer> getCrudService() {
        return this.audienceService;
    }

    @PostMapping("/findAllByListIds")
    public ResponseEntity<ResponseDto> findAllByListIds(@RequestBody Collection<Integer> listIds) {
        Collection<AudienceDto> result = this.audienceService.findAllByListIds(listIds);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.FIND_ALL, result);
        return ResponseEntity.ok(response);
    }

}