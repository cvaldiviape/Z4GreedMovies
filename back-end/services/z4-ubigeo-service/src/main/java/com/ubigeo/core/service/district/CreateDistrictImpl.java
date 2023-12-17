package com.ubigeo.core.service.district;

import com.ubigeo.core.entity.ProvinceEntity;
import com.ubigeo.core.entity.DistrictEntity;
import com.ubigeo.core.entity.mapper.ProvinceMapper;
import com.ubigeo.core.entity.mapper.DistrictMapper;
import com.ubigeo.core.repository.ProvinceRepository;
import com.ubigeo.core.repository.DistrictRepository;
import com.shared.core.service.CreateService;
import com.shared.dto.ProvinceDto;
import com.shared.dto.DistrictDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("createDistrictImpl")
@Transactional
public class CreateDistrictImpl implements CreateService<DistrictDto> {

    private final DistrictRepository districtRepository;
    private final ProvinceRepository provinceRepository;
    private final DistrictMapper districtMapper;
    private final ProvinceMapper provinceMapper;

    public CreateDistrictImpl(DistrictRepository districtRepository, ProvinceRepository provinceRepository, DistrictMapper districtMapper, ProvinceMapper provinceMapper) {
        this.districtRepository = districtRepository;
        this.provinceRepository = provinceRepository;
        this.districtMapper = districtMapper;
        this.provinceMapper = provinceMapper;
    }

    @Override
    public DistrictDto create(DistrictDto districtDto) {
        this.validateUniqueFields(districtDto);
        this.setComplementaryData(districtDto);
        DistrictEntity districtEntity = this.districtMapper.toEntity(districtDto);
        DistrictEntity districtCreated = this.districtRepository.save(districtEntity);
        return this.districtMapper.toDtoCustom(districtCreated);
    }

    // ------------------------------------------------------------------------- utils ------------------------------------------------------------------------- //
    private void validateUniqueFields(DistrictDto provinceDto) {
        Boolean existsCode = this.districtRepository.existsByCode(provinceDto.getCode());
        Boolean existsName = this.districtRepository.existsByName(provinceDto.getName());
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, provinceDto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, provinceDto.getName());
    }

    private void setComplementaryData(DistrictDto districtDto) {
        Integer idProvince = districtDto.getProvince().getIdProvince();
        ProvinceEntity provinceEntity = this.findProvinceEntityById(idProvince);
        ProvinceDto provinceDto = this.provinceMapper.toDtoIgnoredDepartmentAndListDistricts(provinceEntity);
        districtDto.setProvince(provinceDto);
    }

    private ProvinceEntity findProvinceEntityById(Integer idProvince) {
        return this.provinceRepository.findById(idProvince)
            .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.PROVINCE.getValue(), idProvince));
    }

}