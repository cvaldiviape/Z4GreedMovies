package com.z4greed.core.service.impl;

import com.z4greed.core.models.dto.TypeStatusFilmShowDto;
import com.z4greed.core.models.entity.TypeStatusFilmShowEntity;
import com.z4greed.core.models.mapper.TypeStatusFilmShowMapper;
import com.z4greed.core.repository.TypeStatusFilmShowRepository;
import com.z4greed.core.service.common.HandlerCrudService;
import com.z4greed.shared.exception.ResourceNotFoundException;
import com.z4greed.shared.utils.ValidateUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("typeStatusFilmShowServiceImpl")
@Transactional
public class TypeStatusFilmShowServiceImpl extends HandlerCrudService<TypeStatusFilmShowEntity, TypeStatusFilmShowDto, Integer> {

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
    public void updateEntityFromDto(TypeStatusFilmShowDto dto, TypeStatusFilmShowEntity entity) {
        this.typeStatusFilmShowMapper.updateEntityFromDto(dto, entity);
    }

    @Override
    public TypeStatusFilmShowEntity findById(Integer id) {
        return this.typeStatusFilmShowRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id", id));
    }

    @Override
    public void verifyUnique(TypeStatusFilmShowDto dto) {
        Boolean existsCode = this.typeStatusFilmShowRepository.existsByCode(dto.getCode());
        ValidateUtil.evaluate(existsCode, "The code " + dto.getCode() + " already exists.");
        Boolean existsName = this.typeStatusFilmShowRepository.existsByName(dto.getName());
        ValidateUtil.evaluate(existsName, "The name " + dto.getName() + " already exists.");
    }

    @Override
    public void verifyUnique(Integer id, TypeStatusFilmShowDto dto) {
        Boolean existsCode = this.typeStatusFilmShowRepository.existsByCodeAndIdTypeStatusFilmShowNot(dto.getCode(), id);
        ValidateUtil.evaluate(existsCode, "The code " + dto.getCode() + " already exists.");
        Boolean existsName = this.typeStatusFilmShowRepository.existsByNameAndIdTypeStatusFilmShowNot(dto.getName(), id);
        ValidateUtil.evaluate(existsName, "The name " + dto.getName() + " already exists.");
    }

}