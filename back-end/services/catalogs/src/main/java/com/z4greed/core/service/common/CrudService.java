package com.z4greed.core.service.common;

import com.z4greed.core.models.common.BaseDto;
import com.z4greed.core.models.common.BasePageDto;

public interface CrudService <DTO extends BaseDto, ID> {

    public BasePageDto<DTO> findAll(Integer numberPage, Integer sizePage, String sortBy, String sortDir);

    public DTO findById(ID id);

    public DTO create(DTO dto);

    public DTO update(ID id, DTO dto);

    public DTO delete(ID id);

}