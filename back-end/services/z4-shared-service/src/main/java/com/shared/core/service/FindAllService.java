package com.shared.core.service;

import com.shared.dto.custom.BasePageDto;

@FunctionalInterface
public interface FindAllService<DTO> {

    BasePageDto<DTO> findAll(Integer numberPage, Integer sizePage, String sortBy, String sortDir);

}