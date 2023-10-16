package com.catalogs.core.service.impl;

import com.shared.dto.TypeStatusFilmShowDto;
import com.shared.enums.ValueEnum;
import com.shared.error.GeneralErrorEnum;
import com.shared.utils.ValidateUtil;
import com.catalogs.core.entity.TypeStatusFilmShowEntity;
import com.catalogs.core.entity.mapper.TypeStatusFilmShowMapper;
import com.catalogs.core.repository.TypeStatusFilmShowRepository;
import com.catalogs.core.service.TypeStatusFilmShowService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.List;

@Service("typeStatusFilmShowServiceImpl")
@Transactional
public class TypeStatusFilmShowServiceImpl extends TypeStatusFilmShowService<TypeStatusFilmShowEntity, TypeStatusFilmShowDto, Integer> {

    private final TypeStatusFilmShowRepository typeStatusFilmShowRepository;
    private final TypeStatusFilmShowMapper typeStatusFilmShowMapper;

    public TypeStatusFilmShowServiceImpl(TypeStatusFilmShowRepository typeStatusFilmShowRepository, TypeStatusFilmShowMapper typeStatusFilmShowMapper) {
        this.typeStatusFilmShowRepository = typeStatusFilmShowRepository;
        this.typeStatusFilmShowMapper = typeStatusFilmShowMapper;
    }

    @Override
    public JpaRepository<TypeStatusFilmShowEntity, Integer> getJpaRepository() {
        return this.typeStatusFilmShowRepository;
    }

    @Override
    public TypeStatusFilmShowDto toDto(TypeStatusFilmShowEntity entity) {
        return this.typeStatusFilmShowMapper.toDto(entity);
    }

    @Override
    public TypeStatusFilmShowEntity toEntity(TypeStatusFilmShowDto dto) {
        return this.typeStatusFilmShowMapper.toEntity(dto);
    }

    @Override
    public List<TypeStatusFilmShowDto> toListDtos(List<TypeStatusFilmShowEntity> listEntities) {
        return this.typeStatusFilmShowMapper.toListDtos(listEntities);
    }

    @Override
    public void updateEntityFromDto(TypeStatusFilmShowDto dto, TypeStatusFilmShowEntity entity) {
        this.typeStatusFilmShowMapper.updateEntityFromDto(dto, entity);
    }

    @Override
    public TypeStatusFilmShowEntity findEntityById(Integer id) {
        return this.typeStatusFilmShowRepository.findById(id)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.TYPE_STATUS_FILM_SHOW.getValue(), id));
    }

    @Override
    public void verifyUnique(TypeStatusFilmShowDto dto) {
        Boolean existsCode = this.typeStatusFilmShowRepository.existsByCode(dto.getCode());
        Boolean existsName = this.typeStatusFilmShowRepository.existsByName(dto.getName());
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, dto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, dto.getName());
    }

    @Override
    public void verifyUnique(Integer id, TypeStatusFilmShowDto dto) {
        Boolean existsCode = this.typeStatusFilmShowRepository.existsByCodeAndIdTypeStatusFilmShowNot(dto.getCode(), id);
        Boolean existsName = this.typeStatusFilmShowRepository.existsByNameAndIdTypeStatusFilmShowNot(dto.getName(), id);
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, dto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, dto.getName());
    }

    @Override
    public List<TypeStatusFilmShowDto> findAllByListIds(Collection<Integer> listIds) {
        List<TypeStatusFilmShowEntity> listEntities = this.typeStatusFilmShowRepository.findAllById(listIds);
        return this.typeStatusFilmShowMapper.toListDtos(listEntities);
    }

}