package com.ubigeo.core.controller;

import com.shared.core.controller.HandlerCrudController;
import com.shared.core.service.CrudService;
import com.shared.dto.ProvinceDto;
import com.shared.enums.ControllerMessageEnum;
import com.shared.utils.response.ResponseDto;
import com.shared.utils.response.ResponseUtil;
import com.ubigeo.core.entity.ProvinceEntity;
import com.ubigeo.core.service.ProvinceService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("api/provinces")
public class ProvinceController extends HandlerCrudController<ProvinceDto, Integer> {

    private final ProvinceService<ProvinceEntity, ProvinceDto, Integer> provinceService;

    public ProvinceController(@Qualifier("provinceServiceImpl")ProvinceService<ProvinceEntity, ProvinceDto, Integer> provinceService) {
        this.provinceService = provinceService;
    }

    @Override
    public CrudService<ProvinceDto, Integer> getCrudService() {
        return this.provinceService;
    }

    @PostMapping("/findAllByListIds")
    public ResponseEntity<ResponseDto> findAllByListIds(@RequestBody Collection<Integer> listIds) {
        List<ProvinceDto> result = this.provinceService.findAllByListIds(listIds);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.FIND_ALL, result);
        return ResponseEntity.ok(response);
    }

}