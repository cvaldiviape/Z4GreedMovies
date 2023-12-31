package com.facility.core.service.common;

import com.shared.dto.custom.BasePageDto;
import org.springframework.stereotype.Service;

@Service
public interface CrudService <DTO, ID> {

    public BasePageDto<DTO> findAll(Integer numberPage, Integer sizePage, String sortBy, String sortDir);
    public DTO findById(ID id);
    public DTO create(DTO dto);
    public DTO update(ID id, DTO dto);
    public DTO delete(ID id);

}