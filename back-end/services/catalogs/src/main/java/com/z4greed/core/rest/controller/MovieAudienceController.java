package com.z4greed.core.rest.controller;

import com.z4greed.core.models.dto.MovieAudienceDto;
import com.z4greed.core.models.dto.custom.ResponseDto;
import com.z4greed.core.models.entity.MovieAudienceEntity;
import com.z4greed.core.rest.common.HandlerCrudController;
import com.z4greed.core.service.MovieAudienceService;
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

    @PostMapping("/getAllByListIds")
    public ResponseEntity<ResponseDto> getAllByListIds(@RequestBody Collection<Integer> listIds) {
        List<MovieAudienceDto> result = this.movieAudienceService.getAllByListIds(listIds);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.GET_ALL, result);
        return ResponseEntity.ok(response);
    }

}