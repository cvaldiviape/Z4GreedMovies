package com.catalogs.core.controller;

import com.shared.core.controller.HandlerCrudController;
import com.shared.core.service.CrudService;
import com.shared.dto.MovieAudienceDto;
import com.shared.enums.ControllerMessageEnum;
import com.shared.utils.response.ResponseDto;
import com.shared.utils.response.ResponseUtil;
import com.catalogs.core.entity.MovieAudienceEntity;
import com.catalogs.core.service.MovieAudienceService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("api/movie-audiences")
public class MovieAudienceController extends HandlerCrudController<MovieAudienceDto, Integer> {

    private final MovieAudienceService<MovieAudienceEntity, MovieAudienceDto, Integer> movieAudienceService;

    public MovieAudienceController(@Qualifier("movieAudienceServiceImpl")MovieAudienceService<MovieAudienceEntity, MovieAudienceDto, Integer> movieAudienceService) {
        this.movieAudienceService = movieAudienceService;
    }

    @Override
    public CrudService<MovieAudienceDto, Integer> getCrudService() {
        return this.movieAudienceService;
    }

    @PostMapping("/findAllByListIds")
    public ResponseEntity<ResponseDto> findAllByListIds(@RequestBody Collection<Integer> listIds) {
        List<MovieAudienceDto> result = this.movieAudienceService.findAllByListIds(listIds);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.FIND_ALL, result);
        return ResponseEntity.ok(response);
    }

}