package com.ubigeo.core.service.district;

import com.ubigeo.core.entity.DistrictEntity;
import com.ubigeo.core.entity.mapper.custom.DistrictCustomMapper;
import com.ubigeo.core.repository.DistrictRepository;
import com.shared.core.service.impl.GenericFindByIdService;
import com.shared.dto.DistrictDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.stereotype.Service;

@Service("findByIdDistrictImpl")
public class FindByIdDistrictImpl extends GenericFindByIdService<DistrictEntity, DistrictDto, Integer> {

    private final DistrictRepository districtRepository;
    private final DistrictCustomMapper districtCustomMapper;

    public FindByIdDistrictImpl(DistrictRepository districtRepository, DistrictCustomMapper districtCustomMapper) {
        this.districtRepository = districtRepository;
        this.districtCustomMapper = districtCustomMapper;
    }

    @Override
    public DistrictDto toDto(DistrictEntity districtEntity) {
        return this.districtCustomMapper.toDto(districtEntity);
    }

    @Override
    public DistrictEntity findEntityById(Integer idProvince) {
        return this.districtRepository.findById(idProvince)
            .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.PROVINCE.getValue(), idProvince));
    }

}