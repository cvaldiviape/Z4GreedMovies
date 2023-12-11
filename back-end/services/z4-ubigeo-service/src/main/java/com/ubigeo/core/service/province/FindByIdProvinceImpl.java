package com.ubigeo.core.service.province;

import com.ubigeo.core.entity.ProvinceEntity;
import com.ubigeo.core.entity.mapper.ProvinceCustomMapper;
import com.ubigeo.core.repository.ProvinceRepository;
import com.shared.core.service.impl.GenericFindByIdService;
import com.shared.dto.ProvinceDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.stereotype.Service;

@Service("findByIdProvinceImpl")
public class FindByIdProvinceImpl extends GenericFindByIdService<ProvinceEntity, ProvinceDto, Integer> {

    private final ProvinceRepository provinceRepository;
    private final ProvinceCustomMapper provinceCustomMapper;

    public FindByIdProvinceImpl(ProvinceRepository provinceRepository, ProvinceCustomMapper provinceCustomMapper) {
        this.provinceRepository = provinceRepository;
        this.provinceCustomMapper = provinceCustomMapper;
    }

    @Override
    public ProvinceDto toDto(ProvinceEntity provinceEntity) {
        return this.provinceCustomMapper.toDto(provinceEntity);
    }

    @Override
    public ProvinceEntity findEntityById(Integer idProvince) {
        return this.provinceRepository.findById(idProvince)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.PROVINCE.getValue(), idProvince));
    }

}