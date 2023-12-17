package com.catalogs.core.service.typestatusfilmshow;

import com.catalogs.core.entity.TypeStatusFilmShowEntity;
import com.catalogs.core.entity.mapper.TypeStatusFilmShowMapper;
import com.catalogs.core.repository.TypeStatusFilmShowRepository;
import com.shared.core.service.impl.GenericUpdateService;
import com.shared.dto.external.catalogs.TypeStatusFilmShowDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("updateTypeStatusFilmShowImpl")
public class UpdateTypeStatusFilmShowImpl extends GenericUpdateService<TypeStatusFilmShowEntity, TypeStatusFilmShowDto, Integer> {

    private final TypeStatusFilmShowRepository typeStatusFilmShowRepository;
    private final TypeStatusFilmShowMapper typeStatusFilmShowMapper;

    public UpdateTypeStatusFilmShowImpl(TypeStatusFilmShowRepository typeStatusFilmShowRepository, TypeStatusFilmShowMapper typeStatusFilmShowMapper) {
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
    public void updateEntityFromDto(TypeStatusFilmShowDto typeStatusFilmShowDto, TypeStatusFilmShowEntity typeStatusFilmShowEntity) {
        this.typeStatusFilmShowMapper.updateEntityFromDtoIgnoredId(typeStatusFilmShowDto, typeStatusFilmShowEntity);
    }

    @Override
    public TypeStatusFilmShowEntity findEntityById(Integer idTypeStatusFilmShow) {
        return this.typeStatusFilmShowRepository.findById(idTypeStatusFilmShow)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.TYPE_STATUS_FILM_SHOW.getValue(), idTypeStatusFilmShow));
    }

    @Override
    public void verifyUnique(Integer idTypeStatusFilmShow, TypeStatusFilmShowDto typeStatusFilmShowDto) {
        Boolean existsCode = this.typeStatusFilmShowRepository.existsByCodeAndIdTypeStatusFilmShowNot(typeStatusFilmShowDto.getCode(), idTypeStatusFilmShow);
        Boolean existsName = this.typeStatusFilmShowRepository.existsByNameAndIdTypeStatusFilmShowNot(typeStatusFilmShowDto.getName(), idTypeStatusFilmShow);
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, typeStatusFilmShowDto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, typeStatusFilmShowDto.getName());
    }

}