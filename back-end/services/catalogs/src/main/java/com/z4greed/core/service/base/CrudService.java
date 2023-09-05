package com.z4greed.core.service.base;

public interface CrudService <PAGEABLE, DTO, ID> {

    public PAGEABLE getAll(Integer numberPage, Integer sizePage, String sortBy, String sortDir);

    public DTO getById(ID id);

    public DTO create(DTO dto);

    public DTO update(ID id, DTO dto);

    public DTO delete(ID id);

}