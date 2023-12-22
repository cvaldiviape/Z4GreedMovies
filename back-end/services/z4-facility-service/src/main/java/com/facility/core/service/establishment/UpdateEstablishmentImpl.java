package com.facility.core.service.establishment;

import com.facility.core.entity.EstablishmentEntity;
import com.facility.core.entity.mapper.EstablishmentMapper;
import com.facility.core.repositories.EstablishmentRepository;
import com.shared.core.service.impl.GenericUpdateService;
import com.shared.dto.external.facility.EstablishmentDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("updateEstablishmentImpl")
public class UpdateEstablishmentImpl extends GenericUpdateService<EstablishmentEntity, EstablishmentDto, Integer> {

    private final EstablishmentRepository establishmentRepository;
    private final EstablishmentMapper establishmentMapper;

    public UpdateEstablishmentImpl(EstablishmentRepository establishmentRepository, EstablishmentMapper establishmentMapper) {
        this.establishmentRepository = establishmentRepository;
        this.establishmentMapper = establishmentMapper;
    }

    @Override
    public JpaRepository<EstablishmentEntity, Integer> getJpaRepository() {
        return this.establishmentRepository;
    }

    @Override
    public EstablishmentDto toDto(EstablishmentEntity establishmentEntity) {
        return this.establishmentMapper.toDto(establishmentEntity);
    }

    @Override
    public void updateEntityFromDto(EstablishmentDto establishmentDto, EstablishmentEntity establishmentEntity) {
        this.establishmentMapper.updateEntityFromDtoIgnoredId(establishmentDto, establishmentEntity);
    }

    @Override
    public EstablishmentEntity findEntityById(Integer idEstablishment) {
        return this.establishmentRepository.findById(idEstablishment)
            .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.ESTABLISHMENT.getValue(), idEstablishment));
    }

    @Override
    public void verifyUnique(Integer idEstablishment, EstablishmentDto establishmentDto) {
        Boolean existsCode = this.establishmentRepository.existsByCodeAndIdEstablishmentNot(establishmentDto.getCode(), idEstablishment);
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, establishmentDto.getCode());
    }

}