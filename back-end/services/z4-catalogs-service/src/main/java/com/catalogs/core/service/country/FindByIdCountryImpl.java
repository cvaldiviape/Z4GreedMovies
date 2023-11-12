package com.catalogs.core.service.country;

import com.catalogs.core.entity.CountryEntity;
import com.catalogs.core.entity.mapper.CountryMapper;
import com.catalogs.core.repository.CountryRepository;
import com.shared.core.service.impl.GenericFindByIdService;
import com.shared.dto.CountryDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.stereotype.Service;

@Service("findByIdCountryImpl")
public class FindByIdCountryImpl extends GenericFindByIdService<CountryEntity, CountryDto, Integer> {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    public FindByIdCountryImpl(CountryRepository countryRepository, CountryMapper countryMapper) {
        this.countryRepository = countryRepository;
        this.countryMapper = countryMapper;
    }

    @Override
    public CountryDto toDto(CountryEntity countryEntity) {
        return this.countryMapper.toDto(countryEntity);
    }

    @Override
    public CountryEntity findEntityById(Integer idCountry) {
        return this.countryRepository.findById(idCountry)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.COUNTRY.getValue(), idCountry));
    }

}