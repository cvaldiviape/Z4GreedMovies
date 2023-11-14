package com.ubigeo.core.entity.mapper;

import com.shared.dto.DistrictDto;
import com.ubigeo.core.entity.DistrictEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {DepartmentMapper.class, ProvinceMapper.class})
public interface DistrictMapper {

    @Named("DistrictMapper.toDto")
    public DistrictDto toDto(DistrictEntity entity);
    @Named("DistrictMapper.toEntity")
    public DistrictEntity toEntity(DistrictDto dto);
    @Named("DistrictMapper.toListDtos")
    List<DistrictDto> toListDtos(List<DistrictEntity> listEntities);
    @Named("DistrictMapper.toListEntities")
    List<DistrictEntity> toListEntities(List<DistrictDto> listDtos);
    @Named("DistrictMapper.updateEntityFromDto")
    @Mappings({
            @Mapping(target = "department", qualifiedByName = "DepartmentMapper.updateEntityFromDto"),
            @Mapping(target = "province", qualifiedByName = "ProvinceMapper.updateEntityFromDto"),
    })
    void updateEntityFromDto(DistrictDto dto, @MappingTarget DistrictEntity entity);
    @Named("DistrictMapper.updateEntityFromDtoIgnoredId")
    @Mappings({
            @Mapping(target = "idDistrict", ignore = true),
            @Mapping(target = "department", qualifiedByName = "DepartmentMapper.updateEntityFromDto"),
            @Mapping(target = "province", qualifiedByName = "ProvinceMapper.updateEntityFromDto"),
    })
    void updateEntityFromDtoIgnoredId(DistrictDto dto, @MappingTarget DistrictEntity entity);

}