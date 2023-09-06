package com.z4greed.core.service.common;

import com.z4greed.core.models.common.BaseDto;

public interface CrudService <PAGEABLE, DTO extends BaseDto, ID> {

    public PAGEABLE getAll(Integer numberPage, Integer sizePage, String sortBy, String sortDir);

    public DTO getById(ID id);

    public DTO create(DTO dto);

    public DTO update(ID id, DTO dto);

    public DTO delete(ID id);

}