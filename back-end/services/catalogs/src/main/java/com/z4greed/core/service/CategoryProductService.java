package com.z4greed.core.service;

import com.z4greed.core.models.dto.CategoryProductDto;
import com.z4greed.core.models.common.BasePageDto;
import com.z4greed.core.service.common.CrudService;

public interface CategoryProductService extends CrudService<BasePageDto<CategoryProductDto>, CategoryProductDto, Integer> {

}