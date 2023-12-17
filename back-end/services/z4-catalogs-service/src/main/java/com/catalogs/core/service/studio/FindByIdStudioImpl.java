package com.catalogs.core.service.studio;

import com.catalogs.core.entity.StudioEntity;
import com.catalogs.core.entity.mapper.StudioMapper;
import com.catalogs.core.repository.StudioRepository;
import com.shared.core.service.impl.GenericFindByIdService;
import com.shared.dto.external.catalogs.StudioDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.stereotype.Service;

@Service("findByIdStudioImpl")
public class FindByIdStudioImpl extends GenericFindByIdService<StudioEntity, StudioDto, Integer> {

    private final StudioRepository studioRepository;
    private final StudioMapper studioMapper;

    public FindByIdStudioImpl(StudioRepository studioRepository, StudioMapper studioMapper) {
        this.studioRepository = studioRepository;
        this.studioMapper = studioMapper;
    }

    @Override
    public StudioDto toDto(StudioEntity countryEntity) {
        return this.studioMapper.toDto(countryEntity);
    }

    @Override
    public StudioEntity findEntityById(Integer idCountry) {
        return this.studioRepository.findById(idCountry)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.STUDIO.getValue(), idCountry));
    }

}