package com.catalogs.core.entity.mapper;

import com.catalogs.core.entity.ProfitAgreementsEntity;
import com.shared.dto.ProfitAgreementsDto;
import org.mapstruct.*;
import java.util.Collection;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProfitAgreementsMapper {

    public ProfitAgreementsDto toDto(ProfitAgreementsEntity entity);
    public ProfitAgreementsEntity toEntity(ProfitAgreementsDto dto);
    Collection<ProfitAgreementsDto> toListDtos(Collection<ProfitAgreementsEntity> listEntities);
    Collection<ProfitAgreementsEntity> toListEntities(Collection<ProfitAgreementsDto> listDtos);
    @Named("ProfitAgreementsMapper.updateEntityFromDto")
    void updateEntityFromDto(ProfitAgreementsDto dto, @MappingTarget ProfitAgreementsEntity entity);
    @Named("ProfitAgreementsMapper.updateEntityFromDtoIgnoredId")
    @Mapping(target = "idProfitAgreements", ignore = true)
    void updateEntityFromDtoIgnoredId(ProfitAgreementsDto dto, @MappingTarget ProfitAgreementsEntity entity);

}