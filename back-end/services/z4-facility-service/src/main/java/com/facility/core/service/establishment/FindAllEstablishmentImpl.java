package com.facility.core.service.establishment;

import com.facility.core.entity.EstablishmentEntity;
import com.facility.core.entity.mapper.EstablishmentMapper;
import com.facility.core.repositories.EstablishmentRepository;
import com.shared.core.service.impl.GenericFindAllService;
import com.shared.dto.external.facility.EstablishmentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service("findAllEstablishmentImpl")
public class FindAllEstablishmentImpl extends GenericFindAllService<EstablishmentEntity, EstablishmentDto, Integer> {

    private final EstablishmentRepository establishmentRepository;
    private final EstablishmentMapper establishmentMapper;

    public FindAllEstablishmentImpl(EstablishmentRepository establishmentRepository, EstablishmentMapper establishmentMapper) {
        this.establishmentRepository = establishmentRepository;
        this.establishmentMapper = establishmentMapper;
    }

    @Override
    public JpaRepository<EstablishmentEntity, Integer> getJpaRepository() {
        return this.establishmentRepository;
    }

    @Override
    public Collection<EstablishmentDto> toListDtos(Collection<EstablishmentEntity> listEntities) {
        return this.establishmentMapper.toListDtos(listEntities);
    }

}