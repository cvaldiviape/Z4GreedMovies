package com.catalogs.core.service.typestatusfilmshow;

import com.catalogs.core.entity.TypeStatusFilmShowEntity;
import com.catalogs.core.entity.mapper.TypeStatusFilmShowMapper;
import com.catalogs.core.repository.TypeStatusFilmShowRepository;
import com.shared.core.service.impl.GenericFindByIdService;
import com.shared.dto.TypeStatusFilmShowDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.stereotype.Service;

@Service("findByIdTypeStatusFilmShowImpl")
public class FindByIdTypeStatusFilmShowImpl extends GenericFindByIdService<TypeStatusFilmShowEntity, TypeStatusFilmShowDto, Integer> {

    private final TypeStatusFilmShowRepository typeStatusFilmShowRepository;
    private final TypeStatusFilmShowMapper typeStatusFilmShowMapper;

    public FindByIdTypeStatusFilmShowImpl(TypeStatusFilmShowRepository typeStatusFilmShowRepository, TypeStatusFilmShowMapper typeStatusFilmShowMapper) {
        this.typeStatusFilmShowRepository = typeStatusFilmShowRepository;
        this.typeStatusFilmShowMapper = typeStatusFilmShowMapper;
    }

    @Override
    public TypeStatusFilmShowDto toDto(TypeStatusFilmShowEntity typeStatusFilmShowEntity) {
        return this.typeStatusFilmShowMapper.toDto(typeStatusFilmShowEntity);
    }

    @Override
    public TypeStatusFilmShowEntity findEntityById(Integer idTypeStatusFilmShow) {
        return this.typeStatusFilmShowRepository.findById(idTypeStatusFilmShow)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.TYPE_STATUS_FILM_SHOW.getValue(), idTypeStatusFilmShow));
    }

}