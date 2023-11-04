package com.ubigeo.core.service;

import com.shared.core.service.HandlerCrudService;

import java.util.Collection;
import java.util.List;

public abstract class ProvinceService <ENTITY, DTO, ID> extends HandlerCrudService<ENTITY, DTO, ID> {

    public abstract List<DTO> findAllByListIds(Collection<ID> listIds);

}
