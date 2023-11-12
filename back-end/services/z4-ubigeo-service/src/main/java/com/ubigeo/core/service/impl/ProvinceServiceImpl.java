package com.ubigeo.core.service.impl;

import com.shared.dto.ProvinceDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import com.ubigeo.core.entity.ProvinceEntity;
import com.ubigeo.core.entity.mapper.ProvinceMapper;
import com.ubigeo.core.repository.ProvinceRepository;
import com.ubigeo.core.service.ProvinceService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.List;

@Service("provinceServiceImpl")
@Transactional
public class ProvinceServiceImpl extends ProvinceService<ProvinceEntity,ProvinceDto, Integer> {

    private final ProvinceRepository provinceRepository;
    private final ProvinceMapper provinceMapper;

    public ProvinceServiceImpl(ProvinceRepository provinceRepository, ProvinceMapper provinceMapper) {
        this.provinceRepository = provinceRepository;
        this.provinceMapper = provinceMapper;
    }

    @Override
    public JpaRepository<ProvinceEntity, Integer> getJpaRepository() {
        return this.provinceRepository;
    }

    @Override
    public ProvinceDto toDto(ProvinceEntity entity) {
        return this.provinceMapper.toDto(entity);
    }

    @Override
    public ProvinceEntity toEntity(ProvinceDto dto) {
        return this.provinceMapper.toEntity(dto);
    }

    @Override
    public List<ProvinceDto> toListDtos(List<ProvinceEntity> listEntities) {
        return this.provinceMapper.toListDtos(listEntities);
    }

    @Override
    public void updateEntityFromDto(ProvinceDto dto, ProvinceEntity entity) {
        this.provinceMapper.updateEntityFromDto(dto, entity);
    }

    @Override
    public ProvinceEntity findEntityById(Integer id) {
        return this.provinceRepository.findById(id)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.PROVINCE.getValue(), id));
    }

    @Override
    public void verifyUnique(ProvinceDto dto) {
        Boolean existsCode = this.provinceRepository.existsByCode(dto.getCode());
        Boolean existsName = this.provinceRepository.existsByName(dto.getName());
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, dto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, dto.getName());
    }

    @Override
    public void verifyUnique(Integer id, ProvinceDto dto) {
        Boolean existsCode = this.provinceRepository.existsByCodeAndIdProvinceNot(dto.getCode(), id);
        Boolean existsName = this.provinceRepository.existsByNameAndIdProvinceNot(dto.getName(), id);
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, dto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, dto.getName());
    }

    @Override
    public List<ProvinceDto> findAllByListIds(Collection<Integer> listIds) {
        List<ProvinceEntity> listEntities = this.provinceRepository.findAllById(listIds);
        return this.toListDtos(listEntities);
    }

}