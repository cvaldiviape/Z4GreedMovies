package com.catalogs.core.service.country;

import com.catalogs.core.entity.CountryEntity;
import com.catalogs.core.entity.mapper.CountryMapper;
import com.catalogs.core.repository.CountryRepository;
import com.shared.core.service.impl.GenericCreateService;
import com.shared.dto.external.catalogs.CountryDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("createCountryImpl")
public class CreateCountryImpl extends GenericCreateService<CountryEntity, CountryDto, Integer> {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    public CreateCountryImpl(CountryRepository countryRepository, CountryMapper countryMapper) {
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
    public CountryEntity toEntity(CountryDto countryDto) {
        return this.countryMapper.toEntityIgnoredId(countryDto);
    }

    @Override
    public void verifyUnique(CountryDto countryDto) {
        Boolean existsCode = this.countryRepository.existsByCode(countryDto.getCode());
        Boolean existsName = this.countryRepository.existsByName(countryDto.getName());
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, countryDto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, countryDto.getName());
    }

}