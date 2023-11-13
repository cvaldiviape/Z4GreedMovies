package com.catalogs.core.service.language;

import com.catalogs.core.entity.LanguageEntity;
import com.catalogs.core.entity.mapper.LanguageMapper;
import com.catalogs.core.repository.LanguageRepository;
import com.shared.core.service.impl.GenericCreateService;
import com.shared.dto.LanguageDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("createLanguageImpl")
public class CreateLanguageImpl extends GenericCreateService<LanguageEntity, LanguageDto, Integer> {

    private final LanguageRepository languageRepository;
    private final LanguageMapper languageMapper;

    public CreateLanguageImpl(LanguageRepository languageRepository, LanguageMapper languageMapper) {
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
    public LanguageEntity toEntity(LanguageDto languageDto) {
        return this.languageMapper.toEntityIgnoredId(languageDto);
    }

    @Override
    public void verifyUnique(LanguageDto languageDto) {
        Boolean existsCode = this.languageRepository.existsByCode(languageDto.getCode());
        Boolean existsName = this.languageRepository.existsByName(languageDto.getName());
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, languageDto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, languageDto.getName());
    }

}