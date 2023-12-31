package com.catalogs.core.service.country;

import com.catalogs.core.entity.CountryEntity;
import com.catalogs.core.entity.mapper.CountryMapper;
import com.catalogs.core.repository.CountryRepository;
import com.shared.core.service.impl.GenericUpdateService;
import com.shared.dto.external.catalogs.CountryDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("updateCountryImpl")
public class UpdateCountryImpl extends GenericUpdateService<CountryEntity, CountryDto, Integer> {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    public UpdateCountryImpl(CountryRepository countryRepository, CountryMapper countryMapper) {
        this.countryRepository = countryRepository;
        this.countryMapper = countryMapper;
    }

    @Override
    public JpaRepository<CountryEntity, Integer> getJpaRepository() {
        return this.countryRepository;
    }

    @Override
    public CountryDto toDto(CountryEntity countryEntity) {
        return this.countryMapper.toDto(countryEntity);
    }

    @Override
    public void updateEntityFromDto(CountryDto countryDto, CountryEntity countryEntity) {
        this.countryMapper.updateEntityFromDtoIgnoredId(countryDto, countryEntity);
    }

    @Override
    public CountryEntity findEntityById(Integer idCountry) {
        return this.countryRepository.findById(idCountry)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.COUNTRY.getValue(), idCountry));
    }

    @Override
    public void verifyUnique(Integer idCountry, CountryDto countryDto) {
        Boolean existsCode = this.countryRepository.existsByCodeAndIdCountryNot(countryDto.getCode(), idCountry);
        Boolean existsName = this.countryRepository.existsByNameAndIdCountryNot(countryDto.getName(), idCountry);
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, countryDto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, countryDto.getName());
    }

}