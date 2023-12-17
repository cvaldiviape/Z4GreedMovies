package com.ubigeo.core.service.district;

import com.ubigeo.core.entity.ProvinceEntity;
import com.ubigeo.core.entity.DistrictEntity;
import com.ubigeo.core.entity.mapper.ProvinceMapper;
import com.ubigeo.core.entity.mapper.DistrictMapper;
import com.ubigeo.core.repository.ProvinceRepository;
import com.ubigeo.core.repository.DistrictRepository;
import com.shared.core.service.UpdateService;
import com.shared.dto.external.ubigeo.ProvinceDto;
import com.shared.dto.external.ubigeo.DistrictDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("updateDistrictImpl")
@Transactional
public class UpdateDistrictImpl implements UpdateService<DistrictDto, Integer> {

    private final DistrictRepository districtRepository;
    private final ProvinceRepository provinceRepository;
    private final DistrictMapper districtMapper;
    private final ProvinceMapper provinceMapper;


    public UpdateDistrictImpl(DistrictRepository districtRepository, ProvinceRepository provinceRepository, DistrictMapper districtMapper, ProvinceMapper provinceMapper) {
        this.districtRepository = districtRepository;
        this.provinceRepository = provinceRepository;
        this.districtMapper = districtMapper;
        this.provinceMapper = provinceMapper;
    }

    @Override
    public DistrictDto update(Integer idDistrict, DistrictDto districtDto) {
        DistrictEntity districtEntity = this.findDistricteEntityById(idDistrict);
        this.validateUniqueFields(idDistrict, districtDto);
        this.setComplementaryData(districtDto);
        districtEntity.setProvince(null);
        this.districtMapper.updateEntityFromDtoIgnoredId(districtDto, districtEntity);

        DistrictEntity districtUpdated = this.districtRepository.save(districtEntity);
        return this.districtMapper.toDto(districtUpdated);
    }

    // ------------------------------------------------------------------------- utils ------------------------------------------------------------------------- //
    private DistrictEntity findDistricteEntityById(Integer idDistrict) {
        return this.districtRepository.findById(idDistrict)
            .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.DISTRICT.getValue(), idDistrict));
    }

    private void validateUniqueFields(Integer idDistrict, DistrictDto districtDto) {
        Boolean existsCode = this.districtRepository.existsByCodeAndIdDistrictNot(districtDto.getCode(), idDistrict);
        Boolean existsName = this.districtRepository.existsByNameAndIdDistrictNot(districtDto.getName(), idDistrict);
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, districtDto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, districtDto.getName());
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