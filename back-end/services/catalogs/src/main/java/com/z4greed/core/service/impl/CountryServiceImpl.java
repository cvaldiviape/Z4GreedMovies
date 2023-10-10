package com.z4greed.core.service.impl;

import com.shared.dto.CountryDto;
import com.shared.enums.ValueEnum;
import com.shared.error.GeneralErrorEnum;
import com.shared.utils.ValidateUtil;
import com.z4greed.core.entity.CountryEntity;
import com.z4greed.core.entity.mapper.CountryMapper;
import com.z4greed.core.repository.CountryRepository;
import com.z4greed.core.service.CountryService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.List;

@Service("countryServiceImpl")
@Transactional
public class CountryServiceImpl extends CountryService<CountryEntity, CountryDto, Integer> {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    public CountryServiceImpl(CountryRepository countryRepository, CountryMapper countryMapper) {
        this.countryRepository = countryRepository;
        this.countryMapper = countryMapper;
    }

    @Override
    public JpaRepository<CountryEntity, Integer> getJpaRepository() {
        return this.countryRepository;
    }

    @Override
    public CountryDto toDto(CountryEntity entity) {
        return this.countryMapper.toDto(entity);
    }

    @Override
    public CountryEntity toEntity(CountryDto dto) {
        return this.countryMapper.toEntity(dto);
    }

    @Override
    public List<CountryDto> toListDtos(List<CountryEntity> listEntities) {
        return this.countryMapper.toListDtos(listEntities);
    }

    @Override
    public void updateEntityFromDto(CountryDto dto, CountryEntity entity) {
        this.countryMapper.updateEntityFromDto(dto, entity);
    }

    @Override
    public CountryEntity findEntityById(Integer id) {
        return this.countryRepository.findById(id)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.COUNTRY.getValue(), id));
    }

    @Override
    public void verifyUnique(CountryDto dto) {
        Boolean existsCode = this.countryRepository.existsByCode(dto.getCode());
        Boolean existsName = this.countryRepository.existsByName(dto.getName());
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, dto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, dto.getName());
    }

    @Override
    public void verifyUnique(Integer id, CountryDto dto) {
        Boolean existsCode = this.countryRepository.existsByCodeAndIdCountryNot(dto.getCode(), id);
        Boolean existsName = this.countryRepository.existsByNameAndIdCountryNot(dto.getName(), id);
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, dto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, dto.getName());
    }

    @Override
    public List<CountryDto> findAllByListIds(Collection<Integer> listIds) {
        List<CountryEntity> listEntities = this.countryRepository.findAllById(listIds);
        return this.toListDtos(listEntities);
    }

}