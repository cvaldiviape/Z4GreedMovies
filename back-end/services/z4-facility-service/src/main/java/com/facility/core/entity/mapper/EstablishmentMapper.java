package com.facility.core.entity.mapper;

import com.facility.core.entity.ProductEntity;
import com.shared.dto.external.catalogs.ProductDto;
import org.mapstruct.*;
import java.util.Collection;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EstablishmentMapper {

    public ProductDto toDto(ProductEntity entity);
    public ProductEntity toEntity(ProductDto dto);
    Collection<ProductDto> toListDtos(Collection<ProductEntity> listEntities);
    Collection<ProductEntity> toListEntities(Collection<ProductDto> listDtos);
    @Mapping(target = "idEstablishment", ignore = true)
    void updateEntityFromDto(ProductDto dto, @MappingTarget ProductEntity entity);

}
