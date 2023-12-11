package com.ubigeo.core.service.province;

import com.ubigeo.core.entity.ProvinceEntity;
import com.ubigeo.core.entity.mapper.ProvinceCustomMapper;
import com.ubigeo.core.repository.ProvinceRepository;
import com.shared.core.service.impl.GenericFindAllByListIdsService;
import com.shared.dto.ProvinceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service("findAllProvinceByListIdsImpl")
public class FindAllProvinceByListIdsImpl extends GenericFindAllByListIdsService<ProvinceEntity, ProvinceDto, Integer> {

    private final ProvinceRepository provinceRepository;
    private final ProvinceCustomMapper provinceCustomMapper;

    public FindAllProvinceByListIdsImpl(ProvinceRepository provinceRepository, ProvinceCustomMapper provinceCustomMapper) {
        this.provinceRepository = provinceRepository;
        this.provinceCustomMapper = provinceCustomMapper;
    }

    @Override
    public JpaRepository<ProvinceEntity, Integer> getJpaRepository() {
        return this.provinceRepository;
    }

    @Override
    public Collection<ProvinceDto> toListDtos(Collection<ProvinceEntity> listEntities) {
        return this.provinceCustomMapper.toListDtos(listEntities);
    }

}