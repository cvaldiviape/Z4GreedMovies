package com.z4greed.core.entity.mapper;

import com.shared.dto.CategoryProductDto;
import com.z4greed.core.entity.CategoryProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryProductMapper {

    public CategoryProductDto toDto(CategoryProductEntity entity);
    public CategoryProductEntity toEntity(CategoryProductDto dto);
    List<CategoryProductDto> toListDtos(List<CategoryProductEntity> listEntities);
    List<CategoryProductEntity> toListEntities(List<CategoryProductDto> listDtos);
    @Mapping(target = "idCategoryProduct", ignore = true)
    void updateEntityFromDto(CategoryProductDto dto, @MappingTarget CategoryProductEntity entity);

}