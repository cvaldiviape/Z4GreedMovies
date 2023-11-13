package com.catalogs.core.service.typestatusfilmshow;

import com.catalogs.core.entity.TypeStatusFilmShowEntity;
import com.catalogs.core.entity.mapper.TypeStatusFilmShowMapper;
import com.catalogs.core.repository.TypeStatusFilmShowRepository;
import com.shared.core.service.impl.GenericCreateService;
import com.shared.dto.TypeStatusFilmShowDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("createTypeStatusFilmShowImpl")
public class CreateTypeStatusFilmShowImpl extends GenericCreateService<TypeStatusFilmShowEntity, TypeStatusFilmShowDto, Integer> {

    private final TypeStatusFilmShowRepository typeStatusFilmShowRepository;
    private final TypeStatusFilmShowMapper typeStatusFilmShowMapper;

    public CreateTypeStatusFilmShowImpl(TypeStatusFilmShowRepository typeStatusFilmShowRepository, TypeStatusFilmShowMapper typeStatusFilmShowMapper) {
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
    public TypeStatusFilmShowEntity toEntity(TypeStatusFilmShowDto typeStatusFilmShowDto) {
        return this.typeStatusFilmShowMapper.toEntityIgnoredId(typeStatusFilmShowDto);
    }

    @Override
    public void verifyUnique(TypeStatusFilmShowDto typeStatusFilmShowDto) {
        Boolean existsCode = this.typeStatusFilmShowRepository.existsByCode(typeStatusFilmShowDto.getCode());
        Boolean existsName = this.typeStatusFilmShowRepository.existsByName(typeStatusFilmShowDto.getName());
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, typeStatusFilmShowDto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, typeStatusFilmShowDto.getName());
    }

}