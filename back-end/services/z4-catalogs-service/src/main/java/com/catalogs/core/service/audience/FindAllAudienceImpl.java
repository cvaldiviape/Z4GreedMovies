package com.catalogs.core.service.audience;

import com.catalogs.core.entity.AudienceEntity;
import com.catalogs.core.entity.mapper.AudienceMapper;
import com.catalogs.core.repository.AudienceRepository;
import com.shared.core.service.impl.GenericFindAllService;
import com.shared.dto.external.catalogs.AudienceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service("findAllAudienceImpl")
public class FindAllAudienceImpl extends GenericFindAllService<AudienceEntity, AudienceDto, Integer> {

    private final AudienceRepository audienceRepository;
    private final AudienceMapper audienceMapper;

    public FindAllAudienceImpl(AudienceRepository audienceRepository, AudienceMapper audienceMapper) {
        this.audienceRepository = audienceRepository;
        this.audienceMapper = audienceMapper;
    }

    @Override
    public JpaRepository<AudienceEntity, Integer> getJpaRepository() {
        return this.audienceRepository;
    }

    @Override
    public Collection<AudienceDto> toListDtos(Collection<AudienceEntity> listEntities) {
        return this.audienceMapper.toListDtos(listEntities);
    }

}