package com.catalogs.core.service;

import com.catalogs.core.service.common.HandlerCrudService;
import java.util.Collection;
import java.util.List;

public abstract class LanguageService <ENTITY, DTO, ID> extends HandlerCrudService<ENTITY, DTO, ID> {

    public abstract List<DTO> findAllByListIds(Collection<ID> listIds);

}