package com.ubigeo.core.entity.mapper;

import com.shared.dto.ProvinceDto;
import com.ubigeo.core.entity.ProvinceEntity;
import org.mapstruct.*;
import java.util.Collection;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {DepartmentMapper.class})
public interface ProvinceMapper {

    @Named("ProvinceMapper.toDto")
    ProvinceDto toDto(ProvinceEntity entity);
    @Named("ProvinceMapper.toDtoCustom")
    @Mapping(target = "department", qualifiedByName = "DepartmentMapper.toDtoIgnoredListProvinces")
    ProvinceDto toDtoCustom(ProvinceEntity entity);
    @Named("ProvinceMapper.toDtoIgnoredListDistricts")
    @Mapping(target = "listDistricts", ignore = true)
    ProvinceDto toDtoIgnoredListDistricts(ProvinceEntity entity);
    @Named("ProvinceMapper.toDtoIgnoredDepartmentAndListDistricts")
    @Mappings({
        @Mapping(target = "department", ignore = true),
        @Mapping(target = "listDistricts", ignore = true)
    })
    ProvinceDto toDtoIgnoredDepartmentAndListDistricts(ProvinceEntity entity);
    @Named("ProvinceMapper.toEntity")
    ProvinceEntity toEntity(ProvinceDto dto);
    @Named("ProvinceMapper.toEntityIngoredId")
    @Mapping(target = "idProvince", ignore = true)
    ProvinceEntity toEntityIngoredId(ProvinceDto dto);
    @Named("ProvinceMapper.toListDtos")
    Collection<ProvinceDto> toListDtos(Collection<ProvinceEntity> listEntities);
    @Named("ProvinceMapper.toListEntities")
    Collection<ProvinceEntity> toListEntities(Collection<ProvinceDto> listDtos);
    @Named("ProvinceMapper.updateEntityFromDto")
    void updateEntityFromDto(ProvinceDto dto, @MappingTarget ProvinceEntity entity);
    @Named("ProvinceMapper.updateEntityFromDtoIgnoredId")
    @Mappings({
            @Mapping(target = "idProvince", ignore = true),
            @Mapping(target = "department", qualifiedByName = "DepartmentMapper.updateEntityFromDto"),
    })
    void updateEntityFromDtoIgnoredId(ProvinceDto dto, @MappingTarget ProvinceEntity entity);

}