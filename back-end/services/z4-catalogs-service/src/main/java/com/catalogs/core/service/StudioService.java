package com.catalogs.core.service;

import com.shared.core.service.old.CrudService;
import com.shared.dto.StudioDto;

import java.util.Collection;

public interface StudioService extends CrudService<StudioDto, Integer> {

    Collection<StudioDto> findAllByListIds(Collection<Integer> listIds);

}