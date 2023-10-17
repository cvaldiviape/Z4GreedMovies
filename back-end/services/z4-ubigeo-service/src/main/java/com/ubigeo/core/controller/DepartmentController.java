package com.ubigeo.core.controller;

import com.shared.core.controller.HandlerCrudController;
import com.shared.core.service.CrudService;
import com.shared.dto.DepartmentDto;
import com.shared.enums.ControllerMessageEnum;
import com.shared.utils.response.ResponseDto;
import com.shared.utils.response.ResponseUtil;
import com.ubigeo.core.entity.DepartmentEntity;
import com.ubigeo.core.service.DepartmentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("api/departments")
public class DepartmentController extends HandlerCrudController<DepartmentDto, Integer> {

    private final DepartmentService<DepartmentEntity, DepartmentDto, Integer> departmentService;

    public DepartmentController(@Qualifier("departmentServiceImpl")DepartmentService<DepartmentEntity, DepartmentDto, Integer> departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public CrudService<DepartmentDto, Integer> getCrudService() {
        return this.departmentService;
    }

    @PostMapping("/findAllByListIds")
    public ResponseEntity<ResponseDto> findAllByListIds(@RequestBody Collection<Integer> listIds) {
        List<DepartmentDto> result = this.departmentService.findAllByListIds(listIds);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.FIND_ALL, result);
        return ResponseEntity.ok(response);
    }

}