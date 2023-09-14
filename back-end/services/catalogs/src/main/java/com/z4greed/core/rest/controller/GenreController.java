package com.z4greed.core.rest.controller;

import com.z4greed.core.models.dto.GenreDto;
import com.z4greed.core.models.dto.custom.ResponseDto;
import com.z4greed.core.models.entity.GenreEntity;
import com.z4greed.core.rest.common.HandlerCrudController;
import com.z4greed.core.service.GenreService;
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
@RequestMapping("api/genres")
public class GenreController extends HandlerCrudController<GenreDto, Integer> {

    private final GenreService<GenreEntity, GenreDto,Integer> genreService;

    public GenreController(@Qualifier("genreServiceImpl")GenreService<GenreEntity, GenreDto, Integer> genreService) {
        this.genreService = genreService;
    }

    @Override
    public CrudService<GenreDto, Integer> getCrudService() {
        return this.genreService;
    }

    @PostMapping("/findAllByListIds")
    public ResponseEntity<ResponseDto> findAllByListIds(@RequestBody Collection<Integer> listIds) {
        List<GenreDto> result = this.genreService.findAllByListIds(listIds);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.GET_ALL, result);
        return ResponseEntity.ok(response);
    }

}