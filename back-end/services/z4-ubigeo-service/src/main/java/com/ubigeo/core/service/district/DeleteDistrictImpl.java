package com.ubigeo.core.service.district;

import com.shared.core.service.impl.GenericDeleteService;
import com.shared.dto.DistrictDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import com.ubigeo.core.entity.DistrictEntity;
import com.ubigeo.core.entity.mapper.DistrictCustomMapper;
import com.ubigeo.core.repository.DistrictRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("deleteDistrictImpl")
public class DeleteDistrictImpl extends GenericDeleteService<DistrictEntity, DistrictDto, Integer> {

    private final DistrictRepository districtRepository;
    private final DistrictCustomMapper districtCustomMapper;

    public DeleteDistrictImpl(DistrictRepository districtRepository, DistrictCustomMapper districtCustomMapper) {
        this.districtRepository = districtRepository;
        this.districtCustomMapper = districtCustomMapper;
    }

    @Override
    public JpaRepository<DistrictEntity, Integer> getJpaRepository() {
        return this.districtRepository;
    }

    @Override
    public DistrictDto toDto(DistrictEntity provinceEntity) {
        return this.districtCustomMapper.toDto(provinceEntity);
    }

    @Override
    public DistrictEntity findEntityById(Integer idProvince) {
        return this.districtRepository.findById(idProvince)
            .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.DISTRICT.getValue(), idProvince));
    }

}