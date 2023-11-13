package com.catalogs.core.entity.mapper;

import com.shared.dto.CategoryProductDto;
import com.catalogs.core.entity.CategoryProductEntity;
import org.mapstruct.*;
import java.util.Collection;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryProductMapper {

    @Named("CategoryProductMapper.toDto")
    public CategoryProductDto toDto(CategoryProductEntity entity);
    @Named("CategoryProductMapper.toEntity")
    public CategoryProductEntity toEntity(CategoryProductDto dto);
    @Named("CategoryProductMapper.toEntityIgnoredId")
    @Mapping(target = "idCategoryProduct", ignore = true)
    public CategoryProductEntity toEntityIgnoredId(CategoryProductDto dto);
    @Named("CategoryProductMapper.toListDtos")
    Collection<CategoryProductDto> toListDtos(Collection<CategoryProductEntity> listEntities);
    @Named("CategoryProductMapper.toListEntities")
    Collection<CategoryProductEntity> toListEntities(Collection<CategoryProductDto> listDtos);
    @Named("CategoryProductMapper.updateEntityFromDto")
    void updateEntityFromDto(CategoryProductDto dto, @MappingTarget CategoryProductEntity entity);
    @Named("CategoryProductMapper.updateEntityFromDtoIgnoredId")
    @Mapping(target = "idCategoryProduct", ignore = true)
    void updateEntityFromDtoIgnoredId(CategoryProductDto dto, @MappingTarget CategoryProductEntity entity);

}