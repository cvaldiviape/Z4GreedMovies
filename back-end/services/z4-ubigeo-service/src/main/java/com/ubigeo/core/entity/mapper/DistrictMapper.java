package com.ubigeo.core.entity.mapper;

import com.shared.dto.DistrictDto;
import com.ubigeo.core.entity.DistrictEntity;
import org.mapstruct.*;
import java.util.Collection;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {ProvinceMapper.class})
public interface DistrictMapper {

    @Named("DistrictMapper.toDto")
    public DistrictDto toDto(DistrictEntity entity);
    @Named("DistrictMapper.toDtoCustom")
    @Mapping(target = "province", qualifiedByName = "ProvinceMapper.toDtoIgnoredDepartmentAndListDistricts")
    public DistrictDto toDtoCustom(DistrictEntity entity);
    @Named("DistrictMapper.toEntity")
    public DistrictEntity toEntity(DistrictDto dto);
    @Named("DistrictMapper.toEntityIgnoredId")
    @Mapping(target = "idDistrict", ignore = true)
    public DistrictEntity toEntityIgnoredId(DistrictDto dto);
    @Named("DistrictMapper.toListDtos")
    Collection<DistrictDto> toListDtos(Collection<DistrictEntity> listEntities);
    @Named("DistrictMapper.toListEntities")
    Collection<DistrictEntity> toListEntities(Collection<DistrictDto> listDtos);
    @Named("DistrictMapper.updateEntityFromDto")
    void updateEntityFromDto(DistrictDto dto, @MappingTarget DistrictEntity entity);
    @Named("DistrictMapper.updateEntityFromDtoIgnoredId")
    @Mapping(target = "idDistrict", ignore = true)
    void updateEntityFromDtoIgnoredId(DistrictDto dto, @MappingTarget DistrictEntity entity);

}