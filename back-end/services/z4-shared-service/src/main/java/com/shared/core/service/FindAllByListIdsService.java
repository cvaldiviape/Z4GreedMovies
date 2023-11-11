package com.shared.core.service;

import java.util.Collection;
import java.util.List;

@FunctionalInterface
public interface FindAllByListIdsService<DTO, ID> {

    Collection<DTO> findAllByListIds(Collection<ID> listIds);

}