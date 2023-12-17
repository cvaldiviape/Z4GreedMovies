package com.catalogs.core.entity.mapper;

import com.shared.dto.external.catalogs.ProductDto;
import com.catalogs.core.entity.ProductEntity;
import org.mapstruct.*;
import java.util.Collection;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {CategoryProductMapper.class})
public interface ProductMapper {

    @Named("ProductMapper.toDto")
    public ProductDto toDto(ProductEntity entity);
    @Named("ProductMapper.toEntity")
    public ProductEntity toEntity(ProductDto dto);
    @Named("ProductMapper.toEntityIgnoredId")
    @Mapping(target = "idProduct", ignore = true)
    public ProductEntity toEntityIgnoredId(ProductDto dto);
    @Named("ProductMapper.toListDtos")
    Collection<ProductDto> toListDtos(Collection<ProductEntity> listEntities);
    @Named("ProductMapper.toListEntities")
    Collection<ProductEntity> toListEntities(Collection<ProductDto> listDtos);
    @Named("ProductMapper.updateEntityFromDto")
    @Mappings({
            @Mapping(target = "category", qualifiedByName = "CategoryProductMapper.updateEntityFromDto")
    })
    void updateEntityFromDto(ProductDto dto, @MappingTarget ProductEntity entity);
    @Named("ProductMapper.updateEntityFromDtoIgnoredId")
    @Mappings({
            @Mapping(target = "idProduct", ignore = true),
            @Mapping(target = "category", qualifiedByName = "CategoryProductMapper.updateEntityFromDto")
    })
    void updateEntityFromDtoIgnoredId(ProductDto dto, @MappingTarget ProductEntity entity);

}