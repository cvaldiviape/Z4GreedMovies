package com.catalogs.core.service.studio;

import com.catalogs.core.entity.StudioEntity;
import com.catalogs.core.entity.mapper.StudioMapper;
import com.catalogs.core.repository.StudioRepository;
import com.shared.core.service.impl.GenericFindAllByListIdsService;
import com.shared.dto.external.catalogs.StudioDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service("findAllStudioByListIdsImpl")
public class FindAllStudioByListIdsImpl extends GenericFindAllByListIdsService<StudioEntity, StudioDto, Integer> {

    private final StudioRepository studioRepository;
    private final StudioMapper studioMapper;

    public FindAllStudioByListIdsImpl(StudioRepository studioRepository, StudioMapper studioMapper) {
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