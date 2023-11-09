package com.catalogs.core.service;

import com.shared.core.service.CrudService;
import com.shared.core.service.HandlerCrudService;
import com.shared.dto.StudioDto;

import java.util.Collection;
import java.util.List;

public interface StudioService extends CrudService<StudioDto, Integer> {

    List<StudioDto> findAllByListIds(Collection<Integer> listIds);

}