package com.z4greed.core.rest.controller;

import com.z4greed.core.models.dto.TypeStatusFilmShowDto;
import com.z4greed.core.models.dto.custom.ResponseDto;
import com.z4greed.core.models.entity.TypeStatusFilmShowEntity;
import com.z4greed.core.rest.common.HandlerCrudController;
import com.z4greed.core.service.TypeStatusFilmShowService;
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
@RequestMapping("api/type-status-film-shows")
public class TypeStatusFilmShowController extends HandlerCrudController<TypeStatusFilmShowDto, Integer> {

    private final TypeStatusFilmShowService<TypeStatusFilmShowEntity, TypeStatusFilmShowDto, Integer> typeStatusFilmShowService;

    public TypeStatusFilmShowController(@Qualifier("typeStatusFilmShowServiceImpl")TypeStatusFilmShowService<TypeStatusFilmShowEntity, TypeStatusFilmShowDto, Integer> typeStatusFilmShowService) {
        this.typeStatusFilmShowService = typeStatusFilmShowService;
    }

    @Override
    public CrudService<TypeStatusFilmShowDto, Integer> getCrudService() {
        return this.typeStatusFilmShowService;
    }

    @PostMapping("/getAllByListIds")
    public ResponseEntity<ResponseDto> getAllByListIds(@RequestBody Collection<Integer> listIds) {
        List<TypeStatusFilmShowDto> result = this.typeStatusFilmShowService.getAllByListIds(listIds);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.GET_ALL, result);
        return ResponseEntity.ok(response);
    }

}