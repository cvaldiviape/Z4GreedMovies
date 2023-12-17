package com.catalogs.core.service.language;

import com.catalogs.core.entity.LanguageEntity;
import com.catalogs.core.entity.mapper.LanguageMapper;
import com.catalogs.core.repository.LanguageRepository;
import com.shared.core.service.impl.GenericUpdateService;
import com.shared.dto.external.catalogs.LanguageDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("updateLanguageImpl")
public class UpdateLanguageImpl extends GenericUpdateService<LanguageEntity, LanguageDto, Integer> {

    private final LanguageRepository languageRepository;
    private final LanguageMapper languageMapper;

    public UpdateLanguageImpl(LanguageRepository languageRepository, LanguageMapper languageMapper) {
        this.languageRepository = languageRepository;
        this.languageMapper = languageMapper;
    }

    @Override
    public JpaRepository<LanguageEntity, Integer> getJpaRepository() {
        return this.languageRepository;
    }

    @Override
    public LanguageDto toDto(LanguageEntity languageEntity) {
        return this.languageMapper.toDto(languageEntity);
    }

    @Override
    public void updateEntityFromDto(LanguageDto languageDto, LanguageEntity languageEntity) {
        this.languageMapper.updateEntityFromDtoIgnoredId(languageDto, languageEntity);
    }

    @Override
    public LanguageEntity findEntityById(Integer idLanguage) {
        return this.languageRepository.findById(idLanguage)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.LANGUAGE.getValue(), idLanguage));
    }

    @Override
    public void verifyUnique(Integer idLanguage, LanguageDto languageDto) {
        Boolean existsCode = this.languageRepository.existsByCodeAndIdLanguageNot(languageDto.getCode(), idLanguage);
        Boolean existsName = this.languageRepository.existsByNameAndIdLanguageNot(languageDto.getName(), idLanguage);
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, languageDto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, languageDto.getName());
    }

}