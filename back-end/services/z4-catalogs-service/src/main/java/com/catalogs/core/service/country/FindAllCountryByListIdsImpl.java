package com.catalogs.core.service.country;

import com.catalogs.core.entity.CountryEntity;
import com.catalogs.core.entity.mapper.CountryMapper;
import com.catalogs.core.repository.CountryRepository;
import com.shared.core.service.impl.GenericFindAllByListIdsService;
import com.shared.dto.external.catalogs.CountryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service("findAllCountryByListIdsImpl")
public class FindAllCountryByListIdsImpl extends GenericFindAllByListIdsService<CountryEntity, CountryDto, Integer> {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    public FindAllCountryByListIdsImpl(CountryRepository countryRepository, CountryMapper countryMapper) {
        this.countryRepository = countryRepository;
        this.countryMapper = countryMapper;
    }

    @Override
    public JpaRepository<CountryEntity, Integer> getJpaRepository() {
        return this.countryRepository;
    }

    @Override
    public Collection<CountryDto> toListDtos(Collection<CountryEntity> listEntities) {
        return this.countryMapper.toListDtos(listEntities);
    }

}