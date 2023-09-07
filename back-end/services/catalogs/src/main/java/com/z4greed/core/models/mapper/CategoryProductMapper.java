package com.z4greed.core.models.mapper;

import com.z4greed.core.models.dto.CategoryProductDto;
import com.z4greed.core.models.entity.CategoryProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryProductMapper {

    public CategoryProductDto toDto(CategoryProductEntity entity);
    public CategoryProductEntity toEntity(CategoryProductDto dto);
    @Mapping(target = "idCategoryProduct", ignore = true)
    void updateEntityFromDto(CategoryProductDto dto, @MappingTarget CategoryProductEntity entity);

}