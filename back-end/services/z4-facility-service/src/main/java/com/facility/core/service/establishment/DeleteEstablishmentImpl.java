package com.facility.core.service.establishment;

import com.facility.core.entity.EstablishmentEntity;
import com.facility.core.entity.mapper.EstablishmentMapper;
import com.facility.core.repositories.EstablishmentRepository;
import com.shared.core.service.impl.GenericDeleteService;
import com.shared.dto.external.facility.EstablishmentDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("deleteEstablishmentImpl")
public class DeleteEstablishmentImpl extends GenericDeleteService<EstablishmentEntity, EstablishmentDto, Integer> {

    private final EstablishmentRepository establishmentRepository;
    private final EstablishmentMapper establishmentMapper;

    public DeleteEstablishmentImpl(EstablishmentRepository establishmentRepository, EstablishmentMapper establishmentMapper) {
        this.establishmentRepository = establishmentRepository;
        this.establishmentMapper = establishmentMapper;
    }

    @Override
    public JpaRepository<EstablishmentEntity, Integer> getJpaRepository() {
        return this.establishmentRepository;
    }

    @Override
    public EstablishmentDto toDto(EstablishmentEntity roomEntity) {
        return this.establishmentMapper.toDto(roomEntity);
    }

    @Override
    public EstablishmentEntity findEntityById(Integer idEstablishment) {
        return this.establishmentRepository.findById(idEstablishment)
            .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.ESTABLISHMENT.getValue(), idEstablishment));
    }

}