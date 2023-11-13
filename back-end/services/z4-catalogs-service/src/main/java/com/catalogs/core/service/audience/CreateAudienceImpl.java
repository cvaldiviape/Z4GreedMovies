package com.catalogs.core.service.audience;

import com.catalogs.core.entity.AudienceEntity;
import com.catalogs.core.entity.mapper.AudienceMapper;
import com.catalogs.core.repository.AudienceRepository;
import com.shared.core.service.impl.GenericCreateService;
import com.shared.dto.AudienceDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("createAudienceImpl")
public class CreateAudienceImpl extends GenericCreateService<AudienceEntity, AudienceDto, Integer> {

    private final AudienceRepository audienceRepository;
    private final AudienceMapper audienceMapper;

    public CreateAudienceImpl(AudienceRepository audienceRepository, AudienceMapper audienceMapper) {
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
    public AudienceEntity toEntity(AudienceDto audienceDto) {
        return this.audienceMapper.toEntityIgnoredId(audienceDto);
    }

    @Override
    public void verifyUnique(AudienceDto audienceDto) {
        Boolean existsCode = this.audienceRepository.existsByCode(audienceDto.getCode());
        Boolean existsName = this.audienceRepository.existsByName(audienceDto.getName());
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, audienceDto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, audienceDto.getName());
    }

}