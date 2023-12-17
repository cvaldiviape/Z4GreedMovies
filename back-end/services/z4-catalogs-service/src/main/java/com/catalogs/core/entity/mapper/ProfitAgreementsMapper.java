package com.catalogs.core.entity.mapper;

import com.catalogs.core.entity.ProfitAgreementsEntity;
import com.shared.dto.external.catalogs.ProfitAgreementsDto;
import org.mapstruct.*;
import java.util.Collection;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProfitAgreementsMapper {

    @Named("ProfitAgreementsMapper.toDto")
    public ProfitAgreementsDto toDto(ProfitAgreementsEntity entity);
    @Named("ProfitAgreementsMapper.toEntity")
    public ProfitAgreementsEntity toEntity(ProfitAgreementsDto dto);
    @Named("ProfitAgreementsMapper.toEntityIgnored")
    @Mapping(target = "idProfitAgreements", ignore = true)
    public ProfitAgreementsEntity toEntityIgnored(ProfitAgreementsDto dto);
    @Named("ProfitAgreementsMapper.toListDtos")
    Collection<ProfitAgreementsDto> toListDtos(Collection<ProfitAgreementsEntity> listEntities);
    @Named("ProfitAgreementsMapper.toListEntities")
    Collection<ProfitAgreementsEntity> toListEntities(Collection<ProfitAgreementsDto> listDtos);
    @Named("ProfitAgreementsMapper.updateEntityFromDto")
    void updateEntityFromDto(ProfitAgreementsDto dto, @MappingTarget ProfitAgreementsEntity entity);
    @Named("ProfitAgreementsMapper.updateEntityFromDtoIgnoredId")
    @Mapping(target = "idProfitAgreements", ignore = true)
    void updateEntityFromDtoIgnoredId(ProfitAgreementsDto dto, @MappingTarget ProfitAgreementsEntity entity);

}