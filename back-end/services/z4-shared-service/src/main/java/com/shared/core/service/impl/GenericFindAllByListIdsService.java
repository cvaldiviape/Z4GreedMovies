package com.shared.core.service.impl;

import com.shared.core.service.FindAllByListIdsService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.List;

@Transactional
public abstract class GenericFindAllByListIdsService<ENTITY, DTO, ID> implements FindAllByListIdsService<DTO, ID> {

    public abstract JpaRepository<ENTITY, ID> getJpaRepository();

    public abstract Collection<DTO> toListDtos(Collection<ENTITY> listEntities);

    @Override
    public Collection<DTO> findAllByListIds(Collection<ID> listIds) {
        List<ENTITY> listEntities = this.getJpaRepository().findAllById(listIds);
        return this.toListDtos(listEntities);
    }

}