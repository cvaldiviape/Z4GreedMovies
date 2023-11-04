package com.ubigeo.core.service.impl;

import com.shared.core.service.CrudService;
import com.shared.dto.DistrictDto;
import com.shared.dto.custom.BasePageDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import com.ubigeo.core.entity.DistrictEntity;
import com.ubigeo.core.entity.mapper.DistrictMapper;
import com.ubigeo.core.repository.DistrictRepository;
import com.ubigeo.core.service.DistrictService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.List;

@Service("districtServiceImpl")
@Transactional
public class DistrictServiceImpl extends DistrictService<DistrictEntity, DistrictDto, Integer> {

    private final DistrictRepository districtRepository;
    private final DistrictMapper districtMapper;

    public DistrictServiceImpl(DistrictRepository districtRepository, DistrictMapper districtMapper) {
        this.districtRepository = districtRepository;
        this.districtMapper = districtMapper;
    }

    @Override
    public JpaRepository<DistrictEntity, Integer> getJpaRepository() {
        return this.districtRepository;
    }

    @Override
    public DistrictDto toDto(DistrictEntity entity) {
        return this.districtMapper.toDto(entity);
    }

    @Override
    public DistrictEntity toEntity(DistrictDto dto) {
        return this.districtMapper.toEntity(dto);
    }

    @Override
    public List<DistrictDto> toListDtos(List<DistrictEntity> listEntities) {
        return this.districtMapper.toListDtos(listEntities);
    }

    @Override
    public void updateEntityFromDto(DistrictDto dto, DistrictEntity entity) {
        this.districtMapper.updateEntityFromDto(dto, entity);
    }

    @Override
    public DistrictEntity findEntityById(Integer id) {
        return this.districtRepository.findById(id)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.DISTRICT.getValue(), id));
    }

    @Override
    public void verifyUnique(DistrictDto dto) {
        Boolean existsCode = this.districtRepository.existsByCode(dto.getCode());
        Boolean existsName = this.districtRepository.existsByName(dto.getName());
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, dto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, dto.getName());
    }

    @Override
    public void verifyUnique(Integer id, DistrictDto dto) {
        Boolean existsCode = this.districtRepository.existsByCodeAndIdDistrictNot(dto.getCode(), id);
        Boolean existsName = this.districtRepository.existsByNameAndIdDistrictNot(dto.getName(), id);
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, dto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, dto.getName());
    }

    @Override
    public List<DistrictDto> findAllByListIds(Collection<Integer> listIds) {
        List<DistrictEntity> listEntities = this.districtRepository.findAllById(listIds);
        return this.toListDtos(listEntities);
    }

}