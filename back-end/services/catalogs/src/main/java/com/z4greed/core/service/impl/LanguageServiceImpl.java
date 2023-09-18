package com.z4greed.core.service.impl;

import com.shared.dto.LanguageDto;
import com.shared.enums.ValueEnum;
import com.shared.error.GeneralErrorEnum;
import com.shared.utils.ValidateUtil;
import com.z4greed.core.models.entity.LanguageEntity;
import com.z4greed.core.models.mapper.LanguageMapper;
import com.z4greed.core.repository.LanguageRepository;
import com.z4greed.core.service.LanguageService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.List;

@Service("languageServiceImpl")
@Transactional
public class LanguageServiceImpl extends LanguageService<LanguageEntity, LanguageDto, Integer> {

    private final LanguageRepository languageRepository;
    private final LanguageMapper languageMapper;

    public LanguageServiceImpl(LanguageRepository languageRepository, LanguageMapper languageMapper) {
        this.languageRepository = languageRepository;
        this.languageMapper = languageMapper;
    }

    @Override
    public JpaRepository<LanguageEntity, Integer> getJpaRepository() {
        return this.languageRepository;
    }

    @Override
    public LanguageDto toDto(LanguageEntity entity) {
        return this.languageMapper.toDto(entity);
    }

    @Override
    public LanguageEntity toEntity(LanguageDto dto) {
        return this.languageMapper.toEntity(dto);
    }

    @Override
    public List<LanguageDto> toListDtos(List<LanguageEntity> listEntities) {
        return this.languageMapper.toListDtos(listEntities);
    }

    @Override
    public void updateEntityFromDto(LanguageDto dto, LanguageEntity entity) {
        this.languageMapper.updateEntityFromDto(dto, entity);
    }

    @Override
    public LanguageEntity findEntityById(Integer id) {
        return this.languageRepository.findById(id)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.LANGUAGE.getValue(), id));
    }

    @Override
    public void verifyUnique(LanguageDto dto) {
        Boolean existsCode = this.languageRepository.existsByCode(dto.getCode());
        ValidateUtil.evaluateTrue(existsCode, GeneralErrorEnum.ER000005, ValueEnum.CODE.getValue(), dto.getCode());
        Boolean existsName = this.languageRepository.existsByName(dto.getName());
        ValidateUtil.evaluateTrue(existsName, GeneralErrorEnum.ER000005, ValueEnum.NAME.getValue(), dto.getName());
    }

    @Override
    public void verifyUnique(Integer id, LanguageDto dto) {
        Boolean existsCode = this.languageRepository.existsByCodeAndIdLanguageNot(dto.getCode(), id);
        ValidateUtil.evaluateTrue(existsCode, GeneralErrorEnum.ER000005, ValueEnum.CODE.getValue(), dto.getCode());
        Boolean existsName = this.languageRepository.existsByNameAndIdLanguageNot(dto.getName(), id);
        ValidateUtil.evaluateTrue(existsName, GeneralErrorEnum.ER000005, ValueEnum.NAME.getValue(), dto.getName());
    }

    @Override
    public List<LanguageDto> findAllByListIds(Collection<Integer> listIds) {
        List<LanguageEntity> listEntities = this.languageRepository.findAllById(listIds);
        return  this.toListDtos(listEntities);
    }

}