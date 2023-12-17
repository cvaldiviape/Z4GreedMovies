package com.ubigeo.core.service.province;

import com.ubigeo.core.entity.ProvinceEntity;
import com.ubigeo.core.entity.mapper.custom.ProvinceCustomMapper;
import com.ubigeo.core.repository.ProvinceRepository;
import com.shared.core.service.impl.GenericDeleteService;
import com.shared.dto.ProvinceDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("deleteProvinceImpl")
public class DeleteProvinceImpl extends GenericDeleteService<ProvinceEntity, ProvinceDto, Integer> {

    private final ProvinceRepository provinceRepository;
    private final ProvinceCustomMapper provinceCustomMapper;

    public DeleteProvinceImpl(ProvinceRepository provinceRepository, ProvinceCustomMapper provinceCustomMapper) {
        this.provinceRepository = provinceRepository;
        this.provinceCustomMapper = provinceCustomMapper;
    }

    @Override
    public JpaRepository<ProvinceEntity, Integer> getJpaRepository() {
        return this.provinceRepository;
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