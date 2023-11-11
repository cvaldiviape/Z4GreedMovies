package com.catalogs.core.entity.mapper;

import com.shared.dto.CategoryProductDto;
import com.catalogs.core.entity.CategoryProductEntity;
import org.mapstruct.*;

import java.util.Collection;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryProductMapper {

    public CategoryProductDto toDto(CategoryProductEntity entity);
    public CategoryProductEntity toEntity(CategoryProductDto dto);
    Collection<CategoryProductDto> toListDtos(Collection<CategoryProductEntity> listEntities);
    Collection<CategoryProductEntity> toListEntities(Collection<CategoryProductDto> listDtos);
    @Named("CategoryProductMapper.updateEntityFromDto")
    void updateEntityFromDto(CategoryProductDto dto, @MappingTarget CategoryProductEntity entity);
    @Named("CategoryProductMapper.updateEntityFromDtoIgnoredId")
    @Mapping(target = "idCategoryProduct", ignore = true)
    void updateEntityFromDtoIgnoredId(CategoryProductDto dto, @MappingTarget CategoryProductEntity entity);

}