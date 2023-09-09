package com.z4greed.core.service.impl;

import com.z4greed.core.models.dto.GenreDto;
import com.z4greed.core.models.entity.GenreEntity;
import com.z4greed.core.models.mapper.GenreMapper;
import com.z4greed.core.repository.GenreRepository;
import com.z4greed.core.service.common.HandlerCrudService;
import com.z4greed.shared.exception.ResourceNotFoundException;
import com.z4greed.shared.utils.ValidateUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("genreServiceImpl")
@Transactional
public class GenreServiceImpl extends HandlerCrudService<GenreEntity,GenreDto, Integer> {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    public GenreServiceImpl(GenreRepository genreRepository, GenreMapper genreMapper) {
        this.genreRepository = genreRepository;
        this.genreMapper = genreMapper;
    }

    @Override
    public JpaRepository<GenreEntity, Integer> getJpaRepository() {
        return this.genreRepository;
    }

    @Override
    public GenreDto toDto(GenreEntity entity) {
        return this.genreMapper.toDto(entity);
    }

    @Override
    public GenreEntity toEntity(GenreDto dto) {
        return this.genreMapper.toEntity(dto);
    }

    @Override
    public void updateEntityFromDto(GenreDto dto, GenreEntity entity) {
        this.genreMapper.updateEntityFromDto(dto, entity);
    }

    @Override
    public GenreEntity findById(Integer id) {
        return this.genreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id", id));
    }

    @Override
    public void verifyUnique(GenreDto dto) {
        Boolean existsCode = this.genreRepository.existsByCode(dto.getCode());
        ValidateUtil.evaluate(existsCode, "The code " + dto.getCode() + " already exists.");
        Boolean existsName = this.genreRepository.existsByName(dto.getName());
        ValidateUtil.evaluate(existsName, "The name " + dto.getName() + " already exists.");
    }

    @Override
    public void verifyUnique(Integer id, GenreDto dto) {
        Boolean existsCode = this.genreRepository.existsByCodeAndIdGenreNot(dto.getCode(), id);
        ValidateUtil.evaluate(existsCode, "The code " + dto.getCode() + " already exists.");
        Boolean existsName = this.genreRepository.existsByNameAndIdGenreNot(dto.getName(), id);
        ValidateUtil.evaluate(existsName, "The name " + dto.getName() + " already exists.");
    }

}