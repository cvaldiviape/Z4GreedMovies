package com.z4greed.core.service.common;

import com.shared.dto.custom.BasePageDto;
import com.shared.utils.PageUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public abstract class HandlerCrudService<ENTITY, DTO, ID> implements CrudService<DTO, ID> {

    public abstract JpaRepository<ENTITY, ID> getJpaRepository();
    public abstract DTO toDto(ENTITY entity);
    public abstract ENTITY toEntity(DTO dto);
    public abstract List<DTO> toListDtos(List<ENTITY> listEntities);
    public abstract void updateEntityFromDto(DTO dto, ENTITY entity);
    public abstract ENTITY findEntityById(ID id);
    public abstract void verifyUnique(DTO dto);
    public abstract void verifyUnique(ID id, DTO dto);

    @Override
    public BasePageDto<DTO> findAll(Integer numberPage, Integer sizePage, String sortBy, String sortDir) {
        Pageable pageable = PageUtil.getPageable(numberPage, sizePage, sortBy, sortDir);
        Page<ENTITY> pageData = this.getJpaRepository().findAll(pageable);
        List<ENTITY> listEntities = pageData.getContent();

        List<DTO> listDtos = this.toListDtos(listEntities);

        return BasePageDto.<DTO>builder()
                .listElements(listDtos)
                .numberPage(pageData.getNumber())
                .sizePage(pageData.getSize())
                .totalElements(pageData.getTotalElements())
                .totalPages(pageData.getTotalPages())
                .isLastPage(pageData.isLast())
                .build();
    }

    @Override
    public DTO findById(ID id) {
        ENTITY entity = this.findEntityById(id);
        return this.toDto(entity);
    }

    @Override
    public DTO create(DTO dto) {
        this.verifyUnique(dto);
        ENTITY entity = this.toEntity(dto);
        ENTITY entityCreated = this.getJpaRepository().save(entity);
        return this.toDto(entityCreated);
    }

    @Override
    public DTO update(ID id, DTO dto) {
        ENTITY entity = this.findEntityById(id);
        this.verifyUnique(id, dto);
        this.updateEntityFromDto(dto, entity);
        ENTITY entityUpdated = this.getJpaRepository().save(entity);
        return this.toDto(entityUpdated);
    }

    @Override
    public DTO delete(ID id) {
        ENTITY entity = this.findEntityById(id);
        this.getJpaRepository().delete(entity);
        return this.toDto(entity);
    }

}