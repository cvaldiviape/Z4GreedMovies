package com.catalogs.core.service.language;

import com.catalogs.core.entity.LanguageEntity;
import com.catalogs.core.entity.mapper.LanguageMapper;
import com.catalogs.core.repository.LanguageRepository;
import com.shared.core.service.impl.GenericFindByIdService;
import com.shared.dto.LanguageDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.stereotype.Service;

@Service("findByIdLanguageImpl")
public class FindByIdLanguageImpl extends GenericFindByIdService<LanguageEntity, LanguageDto, Integer> {

    private final LanguageRepository languageRepository;
    private final LanguageMapper languageMapper;

    public FindByIdLanguageImpl(LanguageRepository languageRepository, LanguageMapper languageMapper) {
        this.languageRepository = languageRepository;
        this.languageMapper = languageMapper;
    }

    @Override
    public LanguageDto toDto(LanguageEntity languageEntity) {
        return this.languageMapper.toDto(languageEntity);
    }

    @Override
    public LanguageEntity findEntityById(Integer idLanguage) {
        return this.languageRepository.findById(idLanguage)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.LANGUAGE.getValue(), idLanguage));
    }

}