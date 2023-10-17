package com.ubigeo.core.entity.mapper;

import com.shared.dto.ProvinceDto;
import com.ubigeo.core.entity.ProvinceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {DepartmentMapper.class})
public interface ProvinceMapper {

    public ProvinceDto toDto(ProvinceEntity entity);
    public ProvinceEntity toEntity(ProvinceDto dto);
    List<ProvinceDto> toListDtos(List<ProvinceEntity> listEntities);
    List<ProvinceEntity> toListEntities(List<ProvinceDto> listDtos);
    @Mapping(target = "idProvince", ignore = true)
    void updateEntityFromDto(ProvinceDto dto, @MappingTarget ProvinceEntity entity);

}