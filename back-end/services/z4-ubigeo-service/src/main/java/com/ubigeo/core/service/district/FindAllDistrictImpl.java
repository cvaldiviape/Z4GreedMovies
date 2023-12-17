package com.ubigeo.core.service.district;

import com.ubigeo.core.entity.DistrictEntity;
import com.ubigeo.core.entity.mapper.custom.DistrictCustomMapper;
import com.ubigeo.core.repository.DistrictRepository;
import com.shared.core.service.impl.GenericFindAllService;
import com.shared.dto.DistrictDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service("findAllDistrictImpl")
public class FindAllDistrictImpl extends GenericFindAllService<DistrictEntity, DistrictDto, Integer> {

    private final DistrictRepository districtRepository;
    private final DistrictCustomMapper districtCustomMapper;

    public FindAllDistrictImpl(DistrictRepository districtRepository, DistrictCustomMapper districtCustomMapper) {
        this.districtRepository = districtRepository;
        this.districtCustomMapper = districtCustomMapper;
    }

    @Override
    public JpaRepository<DistrictEntity, Integer> getJpaRepository() {
        return this.districtRepository;
    }

    @Override
    public Collection<DistrictDto> toListDtos(Collection<DistrictEntity> listEntities) {
        return this.districtCustomMapper.toListDtos(listEntities);
    }

}