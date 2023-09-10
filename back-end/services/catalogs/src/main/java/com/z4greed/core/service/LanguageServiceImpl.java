package com.z4greed.core.service;

import com.z4greed.core.models.dto.LanguageDto;
import com.z4greed.core.models.entity.LanguageEntity;
import com.z4greed.core.models.mapper.LanguageMapper;
import com.z4greed.core.repository.LanguageRepository;
import com.z4greed.core.service.common.HandlerCrudService;
import com.z4greed.shared.exception.ResourceNotFoundException;
import com.z4greed.shared.utils.ValidateUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("languageServiceImpl")
@Transactional
public class LanguageServiceImpl extends HandlerCrudService<LanguageEntity, LanguageDto, Integer> {

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
    public void updateEntityFromDto(LanguageDto dto, LanguageEntity entity) {
        this.languageMapper.updateEntityFromDto(dto, entity);
    }

    @Override
    public LanguageEntity findById(Integer id) {
        return this.languageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id", id));
    }

    @Override
    public void verifyUnique(LanguageDto dto) {
        Boolean existsCode = this.languageRepository.existsByCode(dto.getCode());
        ValidateUtil.evaluate(existsCode, "The code " + dto.getCode() + " already exists.");
        Boolean existsName = this.languageRepository.existsByName(dto.getName());
        ValidateUtil.evaluate(existsName, "The name " + dto.getName() + " already exists.");
    }

    @Override
    public void verifyUnique(Integer id, LanguageDto dto) {
        Boolean existsCode = this.languageRepository.existsByCodeAndIdLanguageNot(dto.getCode(), id);
        ValidateUtil.evaluate(existsCode, "The code " + dto.getCode() + " already exists.");
        Boolean existsName = this.languageRepository.existsByNameAndIdLanguageNot(dto.getName(), id);
        ValidateUtil.evaluate(existsName, "The name " + dto.getName() + " already exists.");
    }

}