package com.shared.core.controller;

import com.shared.core.service.FindAllByListIdsService;
import com.shared.dto.CountryDto;
import com.shared.enums.ControllerMessageEnum;
import com.shared.utils.response.ResponseDto;
import com.shared.utils.response.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Collection;
import java.util.List;

public interface FindAllByListIdsController<DTO, ID> {

    FindAllByListIdsService<DTO, ID> getFindAllByListIdsService();

    @PostMapping("/findAllByListIds")
    default ResponseEntity<ResponseDto> findAllByListIds(@RequestBody Collection<ID> listIds) {
        Collection<DTO> result = this.getFindAllByListIdsService().findAllByListIds(listIds);
        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.FIND_ALL, result);
        return ResponseEntity.ok(response);
    }

}
