package com.catalogs.core.service.impl;

import com.shared.dto.GenreDto;
import com.shared.enums.ValueEnum;
import com.shared.error.GeneralErrorEnum;
import com.shared.utils.ValidateUtil;
import com.catalogs.core.entity.GenreEntity;
import com.catalogs.core.entity.mapper.GenreMapper;
import com.catalogs.core.repository.GenreRepository;
import com.catalogs.core.service.GenreService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.List;

@Service("genreServiceImpl")
@Transactional
public class GenreServiceImpl extends GenreService<GenreEntity, GenreDto, Integer> {

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
    public List<GenreDto> toListDtos(List<GenreEntity> listEntities) {
        return this.genreMapper.toListDtos(listEntities);
    }

    @Override
    public void updateEntityFromDto(GenreDto dto, GenreEntity entity) {
        this.genreMapper.updateEntityFromDto(dto, entity);
    }

    @Override
    public GenreEntity findEntityById(Integer id) {
        return this.genreRepository.findById(id)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.GENRE.getValue(), id));
    }

    @Override
    public void verifyUnique(GenreDto dto) {
        Boolean existsCode = this.genreRepository.existsByCode(dto.getCode());
        Boolean existsName = this.genreRepository.existsByName(dto.getName());
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, dto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, dto.getName());
    }

    @Override
    public void verifyUnique(Integer id, GenreDto dto) {
        Boolean existsCode = this.genreRepository.existsByCodeAndIdGenreNot(dto.getCode(), id);
        Boolean existsName = this.genreRepository.existsByNameAndIdGenreNot(dto.getName(), id);
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, dto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, dto.getName());
    }

    @Override
    public List<GenreDto> findAllByListIds(Collection<Integer> listIds) {
        List<GenreEntity> listEntities = this.genreRepository.findAllById(listIds);
        return this.toListDtos(listEntities);
    }

}