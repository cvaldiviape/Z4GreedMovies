package com.z4greed.core.service;

import com.z4greed.core.service.common.HandlerCrudService;
import java.util.Collection;
import java.util.List;

public abstract class TypeStatusFilmShowService <ENTITY, DTO, ID> extends HandlerCrudService<ENTITY, DTO, ID> {

    public abstract List<DTO> findAllByListIds(Collection<ID> listIds);

}