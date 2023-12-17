package com.catalogs.core.service.audience;

import com.catalogs.core.entity.AudienceEntity;
import com.catalogs.core.entity.mapper.AudienceMapper;
import com.catalogs.core.repository.AudienceRepository;
import com.shared.core.service.impl.GenericUpdateService;
import com.shared.dto.external.catalogs.AudienceDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("updateAudienceImpl")
public class UpdateAudienceImpl extends GenericUpdateService<AudienceEntity, AudienceDto, Integer> {

    private final AudienceRepository audienceRepository;
    private final AudienceMapper audienceMapper;

    public UpdateAudienceImpl(AudienceRepository audienceRepository, AudienceMapper audienceMapper) {
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
    public void updateEntityFromDto(AudienceDto audienceDto, AudienceEntity audienceEntity) {
        this.audienceMapper.updateEntityFromDtoIgnoredId(audienceDto, audienceEntity);
    }

    @Override
    public AudienceEntity findEntityById(Integer idAudience) {
        return this.audienceRepository.findById(idAudience)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.AUDIENCE.getValue(), idAudience));
    }

    @Override
    public void verifyUnique(Integer idAudience, AudienceDto audienceDto) {
        Boolean existsCode = this.audienceRepository.existsByCodeAndIdAudienceNot(audienceDto.getCode(), idAudience);
        Boolean existsName = this.audienceRepository.existsByNameAndIdAudienceNot(audienceDto.getName(), idAudience);
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, audienceDto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, audienceDto.getName());
    }

}