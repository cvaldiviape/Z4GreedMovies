package com.catalogs.core.service.impl;

import com.catalogs.core.entity.AudienceEntity;
import com.shared.dto.AudienceDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import com.catalogs.core.entity.mapper.AudienceMapper;
import com.catalogs.core.repository.AudienceRepository;
import com.catalogs.core.service.AudienceService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.List;

@Service("audienceServiceImpl")
@Transactional
public class AudienceServiceImpl extends AudienceService<AudienceEntity, AudienceDto, Integer> {

    private final AudienceRepository audienceRepository;
    private final AudienceMapper audienceMapper;

    public AudienceServiceImpl(AudienceRepository audienceRepository, AudienceMapper audienceMapper) {
        this.audienceRepository = audienceRepository;
        this.audienceMapper = audienceMapper;
    }

    @Override
    public JpaRepository<AudienceEntity, Integer> getJpaRepository() {
        return this.audienceRepository;
    }

    @Override
    public AudienceDto toDto(AudienceEntity entity) {
        return this.audienceMapper.toDto(entity);
    }

    @Override
    public AudienceEntity toEntity(AudienceDto dto) {
        return this.audienceMapper.toEntity(dto);
    }

    @Override
    public Collection<AudienceDto> toListDtos(Collection<AudienceEntity> listEntities) {
        return this.audienceMapper.toListDtos(listEntities);
    }

    @Override
    public void updateEntityFromDto(AudienceDto dto, AudienceEntity entity) {
        this.audienceMapper.updateEntityFromDto(dto, entity);
    }

    @Override
    public AudienceEntity findEntityById(Integer id) {
        return this.audienceRepository.findById(id)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.AUDIENCE.getValue(), id));
    }

    @Override
    public void verifyUnique(AudienceDto dto) {
        Boolean existsCode = this.audienceRepository.existsByCode(dto.getCode());
        Boolean existsName = this.audienceRepository.existsByName(dto.getName());
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, dto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, dto.getName());
    }

    @Override
    public void verifyUnique(Integer id, AudienceDto dto) {
        Boolean existsCode = this.audienceRepository.existsByCodeAndIdAudienceNot(dto.getCode(), id);
        Boolean existsName = this.audienceRepository.existsByNameAndIdAudienceNot(dto.getName(), id);
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, dto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, dto.getName());
    }

    @Override
    public Collection<AudienceDto> findAllByListIds(Collection<Integer> listIds) {
        List<AudienceEntity> listEntities = this.audienceRepository.findAllById(listIds);
        return this.toListDtos(listEntities);
    }

}