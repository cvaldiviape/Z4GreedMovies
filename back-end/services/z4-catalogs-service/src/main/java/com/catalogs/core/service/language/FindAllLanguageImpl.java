package com.catalogs.core.service.language;

import com.catalogs.core.entity.LanguageEntity;
import com.catalogs.core.entity.mapper.LanguageMapper;
import com.catalogs.core.repository.LanguageRepository;
import com.shared.core.service.impl.GenericFindAllService;
import com.shared.dto.LanguageDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service("findAllLanguageImpl")
public class FindAllLanguageImpl extends GenericFindAllService<LanguageEntity, LanguageDto, Integer> {

    private final LanguageRepository languageRepository;
    private final LanguageMapper languageMapper;

    public FindAllLanguageImpl(LanguageRepository languageRepository, LanguageMapper languageMapper) {
        this.languageRepository = languageRepository;
        this.languageMapper = languageMapper;
    }

    @Override
    public JpaRepository<LanguageEntity, Integer> getJpaRepository() {
        return this.languageRepository;
    }

    @Override
    public Collection<LanguageDto> toListDtos(Collection<LanguageEntity> listEntities) {
        return this.languageMapper.toListDtos(listEntities);
    }

}