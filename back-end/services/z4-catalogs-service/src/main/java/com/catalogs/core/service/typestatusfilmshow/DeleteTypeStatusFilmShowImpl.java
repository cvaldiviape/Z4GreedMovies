package com.catalogs.core.service.typestatusfilmshow;

import com.catalogs.core.entity.TypeStatusFilmShowEntity;
import com.catalogs.core.entity.mapper.TypeStatusFilmShowMapper;
import com.catalogs.core.repository.TypeStatusFilmShowRepository;
import com.shared.core.service.impl.GenericDeleteService;
import com.shared.dto.external.catalogs.TypeStatusFilmShowDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("deleteTypeStatusFilmShowImpl")
public class DeleteTypeStatusFilmShowImpl extends GenericDeleteService<TypeStatusFilmShowEntity, TypeStatusFilmShowDto, Integer> {

    private final TypeStatusFilmShowRepository typeStatusFilmShowRepository;
    private final TypeStatusFilmShowMapper typeStatusFilmShowMapper;

    public DeleteTypeStatusFilmShowImpl(TypeStatusFilmShowRepository typeStatusFilmShowRepository, TypeStatusFilmShowMapper typeStatusFilmShowMapper) {
        this.typeStatusFilmShowRepository = typeStatusFilmShowRepository;
        this.typeStatusFilmShowMapper = typeStatusFilmShowMapper;
    }

    @Override
    public JpaRepository<TypeStatusFilmShowEntity, Integer> getJpaRepository() {
        return this.typeStatusFilmShowRepository;
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