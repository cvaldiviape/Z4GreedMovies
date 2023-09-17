package com.z4greed.core.model.mapper;

import com.shared.dto.ProductDto;
import com.z4greed.core.model.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    public ProductDto toDto(ProductEntity entity);
    public ProductEntity toEntity(ProductDto dto);
    List<ProductDto> toDtoList(List<ProductEntity> entities);
    List<ProductEntity> toEntityList(List<ProductDto> dtos);
    @Mapping(target = "idProduct", ignore = true)
    void updateEntityFromDto(ProductDto dto, @MappingTarget ProductEntity entity);

}