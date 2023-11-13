package com.catalogs.core.service.audience;

import com.catalogs.core.entity.AudienceEntity;
import com.catalogs.core.entity.mapper.AudienceMapper;
import com.catalogs.core.repository.AudienceRepository;
import com.shared.core.service.impl.GenericDeleteService;
import com.shared.dto.AudienceDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("deleteAudienceImpl")
public class DeleteAudienceImpl extends GenericDeleteService<AudienceEntity, AudienceDto, Integer> {

    private final AudienceRepository audienceRepository;
    private final AudienceMapper audienceMapper;

    public DeleteAudienceImpl(AudienceRepository audienceRepository, AudienceMapper audienceMapper) {
        this.audienceRepository = audienceRepository;
        this.audienceMapper = audienceMapper;
    }

    @Override
    public JpaRepository<AudienceEntity, Integer> getJpaRepository() {
        return this.audienceRepository;
    }

    @Override
    public AudienceDto toDto(AudienceEntity audienceEntity) {
        return this.audienceMapper.toDto(audienceEntity);
    }

    @Override
    public AudienceEntity findEntityById(Integer idAudience) {
        return this.audienceRepository.findById(idAudience)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.AUDIENCE.getValue(), idAudience));
    }

}