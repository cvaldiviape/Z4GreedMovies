package com.shared.core.service.impl;

import com.shared.core.service.FindAllService;
import com.shared.dto.custom.BasePageDto;
import com.shared.utils.PageUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.List;

@Transactional
public abstract class GenericFindAllService<ENTITY, DTO, ID> implements FindAllService<DTO> {

    public abstract JpaRepository<ENTITY, ID> getJpaRepository();

    public abstract Collection<DTO> toListDtos(Collection<ENTITY> listEntities);

    @Override
    public BasePageDto<DTO> findAll(Integer numberPage, Integer sizePage, String sortBy, String sortDir) {
        Pageable pageable = PageUtil.getPageable(numberPage, sizePage, sortBy, sortDir);
        Page<ENTITY> pageData = this.getJpaRepository().findAll(pageable);
        List<ENTITY> listEntities = pageData.getContent();

        Collection<DTO> listDtos = this.toListDtos(listEntities);

        return BasePageDto.<DTO>builder()
                .listElements(listDtos)
                .numberPage(pageData.getNumber())
                .sizePage(pageData.getSize())
                .totalElements(pageData.getTotalElements())
                .totalPages(pageData.getTotalPages())
                .isLastPage(pageData.isLast())
                .build();
    }

}