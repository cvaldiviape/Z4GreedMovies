package com.catalogs.core.controller;

import com.shared.dto.GenreDto;
import com.shared.enums.ControllerMessageEnum;
import com.shared.utils.response.ResponseDto;
import com.shared.utils.response.ResponseUtil;
import com.catalogs.core.entity.GenreEntity;
import com.catalogs.core.controller.common.HandlerCrudController;
import com.catalogs.core.service.GenreService;
import com.catalogs.core.service.common.CrudService;
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
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.FIND_ALL, result);
        return ResponseEntity.ok(response);
    }

}