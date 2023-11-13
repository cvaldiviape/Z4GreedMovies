package com.catalogs.core.service.studio;

import com.catalogs.core.entity.CountryEntity;
import com.catalogs.core.entity.StudioEntity;
import com.catalogs.core.entity.mapper.CountryMapper;
import com.catalogs.core.entity.mapper.StudioMapper;
import com.catalogs.core.repository.CountryRepository;
import com.catalogs.core.repository.StudioRepository;
import com.shared.core.service.UpdateService;
import com.shared.dto.CountryDto;
import com.shared.dto.StudioDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.stereotype.Service;

@Service("updateStudioImpl")
public class UpdateStudioImpl implements UpdateService<StudioDto, Integer> {

    private final StudioRepository studioRepository;
    private final CountryRepository countryRepository;
    private final StudioMapper studioMapper;
    private final CountryMapper countryMapper;

    public UpdateStudioImpl(StudioRepository studioRepository, CountryRepository countryRepository, StudioMapper studioMapper, CountryMapper countryMapper) {
        this.studioRepository = studioRepository;
        this.countryRepository = countryRepository;
        this.studioMapper = studioMapper;
        this.countryMapper = countryMapper;
    }

    @Override
    public StudioDto update(Integer idStudio, StudioDto studioDto) {
        StudioEntity studioEntity = this.findStudioEntityById(idStudio);
        this.validateUniqueFields(idStudio, studioDto);
        this.setComplementaryData(studioDto);
        studioEntity.setCountry(null);
        this.studioMapper.updateEntityFromDtoIgnoredId(studioDto, studioEntity);

        StudioEntity studioUpdated = this.studioRepository.save(studioEntity);
        return this.studioMapper.toDto(studioUpdated);
    }

    // ------------------------------------------------------------------------- utils ------------------------------------------------------------------------- //
    private StudioEntity findStudioEntityById(Integer idStudio) {
        return this.studioRepository.findById(idStudio)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.STUDIO.getValue(), idStudio));
    }

    private void validateUniqueFields(Integer idStudio, StudioDto studioDto) {
        Boolean existsCode = this.studioRepository.existsByCodeAndIdStudioNot(studioDto.getCode(), idStudio);
        Boolean existsName = this.studioRepository.existsByNameAndIdStudioNot(studioDto.getName(), idStudio);
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