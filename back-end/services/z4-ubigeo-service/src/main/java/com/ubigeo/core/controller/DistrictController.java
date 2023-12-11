//package com.ubigeo.core.controller;
//
//import com.shared.core.controller.old.HandlerCrudController;
//import com.shared.core.service.old.CrudService;
//import com.shared.dto.DistrictDto;
//import com.shared.enums.ControllerMessageEnum;
//import com.shared.utils.response.ResponseDto;
//import com.shared.utils.response.ResponseUtil;
//import com.ubigeo.core.entity.DistrictEntity;
//import com.ubigeo.core.service.DistrictService;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import java.util.Collection;
//import java.util.List;
//
//@RestController
//@RequestMapping("api/districts")
//public class DistrictController extends HandlerCrudController<DistrictDto, Integer> {
//
//    private final DistrictService<DistrictEntity, DistrictDto, Integer> districtService;
//
//    public DistrictController(@Qualifier("districtServiceImpl")DistrictService<DistrictEntity, DistrictDto, Integer> districtService) {
//        this.districtService = districtService;
//    }
//
//    @Override
//    public CrudService<DistrictDto, Integer> getCrudService() {
//        return this.districtService;
//    }
//
//    @PostMapping("/findAllByListIds")
//    public ResponseEntity<ResponseDto> findAllByListIds(@RequestBody Collection<Integer> listIds) {
//        List<DistrictDto> result = this.districtService.findAllByListIds(listIds);
//        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.FIND_ALL, result);
//        return ResponseEntity.ok(response);
//    }
//
//}