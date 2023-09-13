package com.z4greed.core.service;

import com.z4greed.core.models.common.BaseDto;
import com.z4greed.core.models.common.BaseEntity;
import com.z4greed.core.service.common.HandlerCrudService;
import java.util.Collection;
import java.util.List;

public abstract class GenreService <ENTITY extends BaseEntity, DTO extends BaseDto, ID> extends HandlerCrudService<ENTITY, DTO, ID> {

    public abstract List<DTO> getAllByListIds(Collection<ID> listIds);

}