package com.catalogs.core.service;

import com.shared.core.service.HandlerCrudService;
import java.util.Collection;
import java.util.List;

public abstract class GenreService <ENTITY, DTO, ID> extends HandlerCrudService<ENTITY, DTO, ID> {

    public abstract Collection<DTO> findAllByListIds(Collection<ID> listIds);

}