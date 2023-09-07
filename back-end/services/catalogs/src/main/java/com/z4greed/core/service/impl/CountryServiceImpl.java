package com.z4greed.core.service.impl;

import com.z4greed.core.models.dto.CountryDto;
import com.z4greed.core.models.entity.CountryEntity;
import com.z4greed.core.models.mapper.CountryMapper;
import com.z4greed.core.repository.CountryRepository;
import com.z4greed.core.service.common.HandlerCrudService;
import com.z4greed.shared.exception.ResourceNotFoundException;
import com.z4greed.shared.utils.ValidateUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("countryServiceImpl")
@Transactional
public class CountryServiceImpl extends HandlerCrudService<CountryEntity, CountryDto, Integer> {

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
    public void updateEntityFromDto(CountryDto dto, CountryEntity entity) {
        this.countryMapper.updateEntityFromDto(dto, entity);
    }

    @Override
    public CountryEntity findById(Integer id) {
        return this.countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id", id));
    }

    @Override
    public void verifyUnique(CountryDto dto) {
        Boolean existsCode = this.countryRepository.existsByCode(dto.getCode());
        ValidateUtil.evaluate(existsCode, "The code " + dto.getCode() + " already exists.");
        Boolean existsName = this.countryRepository.existsByName(dto.getName());
        ValidateUtil.evaluate(existsName, "The name " + dto.getName() + " already exists.");
    }

    @Override
    public void verifyUnique(Integer id, CountryDto dto) {
        Boolean existsCode = this.countryRepository.existsByCodeAndIdCountryNot(dto.getCode(), id);
        ValidateUtil.evaluate(existsCode, "The code " + dto.getCode() + " already exists.");
        Boolean existsName = this.countryRepository.existsByCodeAndIdCountryNot(dto.getName(), id);
        ValidateUtil.evaluate(existsName, "The name " + dto.getName() + " already exists.");
    }

}