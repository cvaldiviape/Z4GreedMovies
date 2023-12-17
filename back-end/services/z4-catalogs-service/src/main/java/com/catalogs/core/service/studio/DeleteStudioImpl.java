package com.catalogs.core.service.studio;

import com.catalogs.core.entity.StudioEntity;
import com.catalogs.core.entity.mapper.StudioMapper;
import com.catalogs.core.repository.StudioRepository;
import com.shared.core.service.impl.GenericDeleteService;
import com.shared.dto.external.catalogs.StudioDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("deleteStudioImpl")
public class DeleteStudioImpl extends GenericDeleteService<StudioEntity, StudioDto, Integer> {

    private final StudioRepository studioRepository;
    private final StudioMapper studioMapper;

    public DeleteStudioImpl(StudioRepository studioRepository, StudioMapper studioMapper) {
        this.studioRepository = studioRepository;
        this.studioMapper = studioMapper;
    }

    @Override
    public JpaRepository<StudioEntity, Integer> getJpaRepository() {
        return this.studioRepository;
    }

    @Override
    public StudioDto toDto(StudioEntity studioEntity) {
        return this.studioMapper.toDto(studioEntity);
    }

    @Override
    public StudioEntity findEntityById(Integer idStudio) {
        return this.studioRepository.findById(idStudio)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.STUDIO.getValue(), idStudio));
    }

}