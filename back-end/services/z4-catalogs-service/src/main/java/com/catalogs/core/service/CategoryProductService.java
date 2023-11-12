package com.catalogs.core.service;

import com.shared.core.service.old.HandlerCrudService;
import java.util.Collection;

public abstract class CategoryProductService <ENTITY, DTO, ID> extends HandlerCrudService<ENTITY, DTO, ID> {

    public abstract Collection<DTO> findAllByListIds(Collection<ID> listIds);

}