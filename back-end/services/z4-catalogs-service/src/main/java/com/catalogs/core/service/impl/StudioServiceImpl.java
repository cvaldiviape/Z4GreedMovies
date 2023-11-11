package com.catalogs.core.service.impl;

import com.catalogs.core.entity.CountryEntity;
import com.catalogs.core.repository.CountryRepository;
import com.catalogs.core.service.StudioService;
import com.shared.dto.StudioDto;
import com.shared.dto.custom.BasePageDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.PageUtil;
import com.shared.utils.ValidateUtil;
import com.catalogs.core.entity.StudioEntity;
import com.catalogs.core.entity.mapper.StudioMapper;
import com.catalogs.core.repository.StudioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.List;

@Service("studioServiceImpl")
@Transactional
public class StudioServiceImpl implements StudioService {

    private final StudioRepository studioRepository;
    private final CountryRepository countryRepository;
    private final StudioMapper studioMapper;

    public StudioServiceImpl(StudioRepository studioRepository, CountryRepository countryRepository, StudioMapper studioMapper) {
        this.studioRepository = studioRepository;
        this.countryRepository = countryRepository;
        this.studioMapper = studioMapper;
    }

    @Override
    public BasePageDto<StudioDto> findAll(Integer numberPage, Integer sizePage, String sortBy, String sortDir) {
        Pageable pageable = PageUtil.getPageable(numberPage, sizePage, sortBy, sortDir);
        Page<StudioEntity> pageData = this.studioRepository.findAll(pageable);
        List<StudioEntity> listEntities = pageData.getContent();

        Collection<StudioDto> listStudios = this.studioMapper.toListDtos(listEntities);

        return BasePageDto.<StudioDto>builder()
                .listElements(listStudios)
                .numberPage(pageData.getNumber())
                .sizePage(pageData.getSize())
                .totalElements(pageData.getTotalElements())
                .totalPages(pageData.getTotalPages())
                .isLastPage(pageData.isLast())
                .build();
    }

    @Override
    public StudioDto findById(Integer idStudio) {
        StudioEntity entity = this.findStudioEntityById(idStudio);
        return this.studioMapper.toDto(entity);
    }

    @Override
    public StudioDto create(StudioDto studioDto) {
        this.validateUniqueFields(studioDto);
        StudioEntity studioEntity = this.studioMapper.toEntity(studioDto);
        setCountry(studioEntity, studioDto);
        StudioEntity studioCreated = this.studioRepository.save(studioEntity);
        return this.studioMapper.toDto(studioCreated);
    }

    @Override
    public StudioDto update(Integer idStudio, StudioDto studioDto) {
        StudioEntity studioEntity = this.findStudioEntityById(idStudio);
        this.validateUniqueFields(idStudio, studioDto);
        this.studioMapper.updateEntityFromDto(studioDto, studioEntity);
        StudioEntity studioUpdated = this.studioRepository.save(studioEntity);
        return this.studioMapper.toDto(studioUpdated);
    }

    @Override
    public StudioDto delete(Integer idStudio) {
        StudioEntity studioEntity = this.findStudioEntityById(idStudio);
        this.studioRepository.delete(studioEntity);
        return this.studioMapper.toDto(studioEntity);
    }


    @Override
    public Collection<StudioDto> findAllByListIds(Collection<Integer> listIds) {
        List<StudioEntity> listEntities = this.studioRepository.findAllById(listIds);
        return this.studioMapper.toListDtos(listEntities);
    }

    // ------------------------------------------------------------------------- utils ------------------------------------------------------------------------- //
    private void setCountry(StudioEntity studioEntity, StudioDto studioDto) {
        Integer idCountry = studioDto.getCountry().getIdCountry();
        CountryEntity countryEntity = this.findCountryEntityById(idCountry);
        studioEntity.setCountry(countryEntity);
    }

    private StudioEntity findStudioEntityById(Integer id) {
        return this.studioRepository.findById(id)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.STUDIO.getValue(), id));
    }

    private CountryEntity findCountryEntityById(Integer id) {
        return this.countryRepository.findById(id)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.COUNTRY.getValue(), id));
    }

    private void validateUniqueFields(StudioDto dto) {
        Boolean existsCode = this.studioRepository.existsByCode(dto.getCode());
        Boolean existsName = this.studioRepository.existsByName(dto.getName());
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, dto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, dto.getName());
    }


    private void validateUniqueFields(Integer id, StudioDto dto) {
        Boolean existsCode = this.studioRepository.existsByCodeAndIdStudioNot(dto.getCode(), id);
        Boolean existsName = this.studioRepository.existsByNameAndIdStudioNot(dto.getName(), id);
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, dto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, dto.getName());
    }

}