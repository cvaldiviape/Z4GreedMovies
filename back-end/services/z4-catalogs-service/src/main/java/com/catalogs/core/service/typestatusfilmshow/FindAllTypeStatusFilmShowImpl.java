package com.catalogs.core.service.typestatusfilmshow;

import com.catalogs.core.entity.TypeStatusFilmShowEntity;
import com.catalogs.core.entity.mapper.TypeStatusFilmShowMapper;
import com.catalogs.core.repository.TypeStatusFilmShowRepository;
import com.shared.core.service.impl.GenericFindAllService;
import com.shared.dto.external.catalogs.TypeStatusFilmShowDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service("findAllTypeStatusFilmShowImpl")
public class FindAllTypeStatusFilmShowImpl extends GenericFindAllService<TypeStatusFilmShowEntity, TypeStatusFilmShowDto, Integer> {

    private final TypeStatusFilmShowRepository typeStatusFilmShowRepository;
    private final TypeStatusFilmShowMapper typeStatusFilmShowMapper;

    public FindAllTypeStatusFilmShowImpl(TypeStatusFilmShowRepository typeStatusFilmShowRepository, TypeStatusFilmShowMapper typeStatusFilmShowMapper) {
        this.typeStatusFilmShowRepository = typeStatusFilmShowRepository;
        this.typeStatusFilmShowMapper = typeStatusFilmShowMapper;
    }

    @Override
    public JpaRepository<TypeStatusFilmShowEntity, Integer> getJpaRepository() {
        return this.typeStatusFilmShowRepository;
    }

    @Override
    public Collection<TypeStatusFilmShowDto> toListDtos(Collection<TypeStatusFilmShowEntity> listEntities) {
        return this.typeStatusFilmShowMapper.toListDtos(listEntities);
    }

}