package com.catalogs.core.service.studio;

import com.catalogs.core.entity.CountryEntity;
import com.catalogs.core.entity.StudioEntity;
import com.catalogs.core.entity.mapper.CountryMapper;
import com.catalogs.core.entity.mapper.StudioMapper;
import com.catalogs.core.repository.CountryRepository;
import com.catalogs.core.repository.StudioRepository;
import com.shared.core.service.CreateService;
import com.shared.dto.external.catalogs.CountryDto;
import com.shared.dto.external.catalogs.StudioDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.stereotype.Service;

@Service("createStudioImpl")
public class CreateStudioImpl implements CreateService<StudioDto> {

    private final StudioRepository studioRepository;
    private final CountryRepository countryRepository;
    private final StudioMapper studioMapper;
    private final CountryMapper countryMapper;

    public CreateStudioImpl(StudioRepository studioRepository, CountryRepository countryRepository, StudioMapper studioMapper, CountryMapper countryMapper) {
        this.studioRepository = studioRepository;
        this.countryRepository = countryRepository;
        this.studioMapper = studioMapper;
        this.countryMapper = countryMapper;
    }

    @Override
    public StudioDto create(StudioDto studioDto) {
        this.validateUniqueFields(studioDto);
        this.setComplementaryData(studioDto);
        StudioEntity studioEntity = this.studioMapper.toEntity(studioDto);
        StudioEntity studioCreated = this.studioRepository.save(studioEntity);
        return this.studioMapper.toDto(studioCreated);
    }

    // ------------------------------------------------------------------------- utils ------------------------------------------------------------------------- //
    private void validateUniqueFields(StudioDto studioDto) {
        Boolean existsCode = this.studioRepository.existsByCode(studioDto.getCode());
        Boolean existsName = this.studioRepository.existsByName(studioDto.getName());
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, studioDto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, studioDto.getName());
    }

    private void setComplementaryData(StudioDto studioDto) {
        Integer idCountry = studioDto.getCountry().getIdCountry();
        CountryEntity countryEntity = this.findCountryEntityById(idCountry);
        CountryDto countryDto = this.countryMapper.toDto(countryEntity);
        studioDto.setCountry(countryDto);
    }

    private CountryEntity findCountryEntityById(Integer idCountry) {
        return this.countryRepository.findById(idCountry)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.COUNTRY.getValue(), idCountry));
    }

}