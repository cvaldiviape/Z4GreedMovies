package com.facility.core.entity.mapper;

import com.shared.dto.external.catalogs.ProductDto;
import com.facility.core.entity.ProductEntity;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    public ProductDto toDto(ProductEntity entity);
    public ProductEntity toEntity(ProductDto dto);
    List<ProductDto> toListDtos(List<ProductEntity> listEntities);
    List<ProductEntity> toListEntities(List<ProductDto> listDtos);
    @Mapping(target = "idProduct", ignore = true)
    void updateEntityFromDto(ProductDto dto, @MappingTarget ProductEntity entity);

}