package com.facility.core.service.establishment;

import com.facility.core.entity.EstablishmentEntity;
import com.facility.core.entity.mapper.EstablishmentMapper;
import com.facility.core.repositories.EstablishmentRepository;
import com.shared.core.service.impl.GenericFindByIdService;
import com.shared.dto.external.facility.EstablishmentDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.stereotype.Service;

@Service("findByIdEstablishmentImpl")
public class FindByIdEstablishmentImpl extends GenericFindByIdService<EstablishmentEntity, EstablishmentDto, Integer> {

    private final EstablishmentRepository establishmentRepository;
    private final EstablishmentMapper establishmentMapper;

    public FindByIdEstablishmentImpl(EstablishmentRepository establishmentRepository, EstablishmentMapper establishmentMapper) {
        this.establishmentRepository = establishmentRepository;
        this.establishmentMapper = establishmentMapper;
    }

    @Override
    public EstablishmentDto toDto(EstablishmentEntity establishmentEntity) {
        return this.establishmentMapper.toDto(establishmentEntity);
    }

    @Override
    public EstablishmentEntity findEntityById(Integer idEstablishment) {
        return this.establishmentRepository.findById(idEstablishment)
            .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.ESTABLISHMENT.getValue(), idEstablishment));
    }

}