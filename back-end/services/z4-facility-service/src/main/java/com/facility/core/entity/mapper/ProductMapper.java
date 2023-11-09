package com.facility.core.entity.mapper;

import com.shared.dto.ProductDto;
import com.facility.core.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
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