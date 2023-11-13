package com.catalogs.core.service.studio;

import com.catalogs.core.entity.StudioEntity;
import com.catalogs.core.entity.mapper.StudioMapper;
import com.catalogs.core.repository.StudioRepository;
import com.shared.core.service.impl.GenericFindAllService;
import com.shared.dto.StudioDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service("findAllStudioImpl")
public class FindAllStudioImpl extends GenericFindAllService<StudioEntity, StudioDto, Integer> {

    private final StudioRepository studioRepository;
    private final StudioMapper studioMapper;

    public FindAllStudioImpl(StudioRepository studioRepository, StudioMapper studioMapper) {
        this.studioRepository = studioRepository;
        this.studioMapper = studioMapper;
    }

    @Override
    public JpaRepository<StudioEntity, Integer> getJpaRepository() {
        return this.studioRepository;
    }

    @Override
    public Collection<StudioDto> toListDtos(Collection<StudioEntity> listEntities) {
        return this.studioMapper.toListDtos(listEntities);
    }

}