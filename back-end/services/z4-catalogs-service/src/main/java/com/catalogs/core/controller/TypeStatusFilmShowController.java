package com.catalogs.core.controller;

import com.shared.core.controller.HandlerCrudController;
import com.shared.core.service.CrudService;
import com.shared.dto.TypeStatusFilmShowDto;
import com.shared.enums.ControllerMessageEnum;
import com.shared.utils.response.ResponseDto;
import com.shared.utils.response.ResponseUtil;
import com.catalogs.core.entity.TypeStatusFilmShowEntity;
import com.catalogs.core.service.TypeStatusFilmShowService;
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

    @PostMapping("/findAllByListIds")
    public ResponseEntity<ResponseDto> findAllByListIds(@RequestBody Collection<Integer> listIds) {
        List<TypeStatusFilmShowDto> result = this.typeStatusFilmShowService.findAllByListIds(listIds);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.FIND_ALL, result);
        return ResponseEntity.ok(response);
    }

}