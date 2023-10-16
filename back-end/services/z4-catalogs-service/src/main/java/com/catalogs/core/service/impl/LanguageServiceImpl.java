package com.catalogs.core.service.impl;

import com.shared.dto.LanguageDto;
import com.shared.enums.ValueEnum;
import com.shared.error.GeneralErrorEnum;
import com.shared.utils.ValidateUtil;
import com.catalogs.core.entity.LanguageEntity;
import com.catalogs.core.entity.mapper.LanguageMapper;
import com.catalogs.core.repository.LanguageRepository;
import com.catalogs.core.service.LanguageService;
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
        Boolean existsName = this.languageRepository.existsByName(dto.getName());
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, dto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, dto.getName());
    }

    @Override
    public void verifyUnique(Integer id, LanguageDto dto) {
        Boolean existsCode = this.languageRepository.existsByCodeAndIdLanguageNot(dto.getCode(), id);
        Boolean existsName = this.languageRepository.existsByNameAndIdLanguageNot(dto.getName(), id);
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, dto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, dto.getName());
    }

    @Override
    public List<LanguageDto> findAllByListIds(Collection<Integer> listIds) {
        List<LanguageEntity> listEntities = this.languageRepository.findAllById(listIds);
        return  this.toListDtos(listEntities);
    }

}