package com.ubigeo.core.entity.mapper;

import com.shared.dto.DistrictDto;
import com.ubigeo.core.entity.DistrictEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {DepartmentMapper.class, ProvinceMapper.class})
public interface DistrictMapper {

    public DistrictDto toDto(DistrictEntity entity);
    public DistrictEntity toEntity(DistrictDto dto);
    List<DistrictDto> toListDtos(List<DistrictEntity> listEntities);
    List<DistrictEntity> toListEntities(List<DistrictDto> listDtos);
    @Mapping(target = "idDistrict", ignore = true)
    void updateEntityFromDto(DistrictDto dto, @MappingTarget DistrictEntity entity);

}