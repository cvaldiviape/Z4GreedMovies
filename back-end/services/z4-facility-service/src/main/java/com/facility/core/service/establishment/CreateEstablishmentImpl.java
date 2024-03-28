package com.facility.core.service.establishment;

import com.facility.core.entity.EstablishmentEntity;
import com.facility.core.entity.mapper.EstablishmentMapper;
import com.facility.core.repositories.EstablishmentRepository;
import com.shared.core.service.impl.GenericCreateService;
import com.shared.dto.external.facility.EstablishmentDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("createEstablishmentImpl")
public class CreateEstablishmentImpl extends GenericCreateService<EstablishmentEntity, EstablishmentDto, Integer> {

    private final EstablishmentRepository establishmentRepository;
    private final EstablishmentMapper establishmentMapper;

    public CreateEstablishmentImpl(EstablishmentRepository establishmentRepository, EstablishmentMapper establishmentMapper) {
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
    public EstablishmentEntity toEntity(EstablishmentDto establishmentDto) {
        return this.establishmentMapper.toEntityIgnoredId(establishmentDto);
    }

    @Override
    public void verifyUnique(EstablishmentDto establishmentDto) {
        Boolean existsCode = this.establishmentRepository.existsByCode(establishmentDto.getCode());
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, establishmentDto.getCode());
    }

}