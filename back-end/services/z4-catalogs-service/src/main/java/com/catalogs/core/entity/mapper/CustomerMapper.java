package com.catalogs.core.entity.mapper;

import com.shared.dto.external.catalogs.CustomerDto;
import com.catalogs.core.entity.CustomerEntity;
import org.mapstruct.*;
import java.util.Collection;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {

    @Named("CustomerMapper.toDto")
    public CustomerDto toDto(CustomerEntity entity);
    @Named("CustomerMapper.toEntity")
    public CustomerEntity toEntity(CustomerDto dto);
    @Named("CustomerMapper.toEntityIgnoredId")
    @Mapping(target = "idCustomer", ignore = true)
    public CustomerEntity toEntityIgnoredId(CustomerDto dto);
    @Named("CustomerMapper.toListDtos")
    Collection<CustomerDto> toListDtos(Collection<CustomerEntity> listEntities);
    @Named("CustomerMapper.toListEntities")
    Collection<CustomerEntity> toListEntities(Collection<CustomerDto> listDtos);
    @Named("CustomerMapper.updateEntityFromDto")
    @Mapping(target = "idCustomer", ignore = true)
    void updateEntityFromDto(CustomerDto dto, @MappingTarget CustomerEntity entity);

}