package com.z4greed.core.service.impl;

import com.shared.dto.GenreDto;
import com.shared.enums.ValueEnum;
import com.shared.error.GeneralErrorEnum;
import com.shared.utils.ValidateUtil;
import com.z4greed.core.models.entity.GenreEntity;
import com.z4greed.core.models.mapper.GenreMapper;
import com.z4greed.core.repository.GenreRepository;
import com.z4greed.core.service.GenreService;
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
        ValidateUtil.evaluateTrue(existsCode, GeneralErrorEnum.ER000005, ValueEnum.CODE.getValue(), dto.getCode());
        Boolean existsName = this.genreRepository.existsByName(dto.getName());
        ValidateUtil.evaluateTrue(existsName, GeneralErrorEnum.ER000005, ValueEnum.NAME.getValue(), dto.getName());
    }

    @Override
    public void verifyUnique(Integer id, GenreDto dto) {
        Boolean existsCode = this.genreRepository.existsByCodeAndIdGenreNot(dto.getCode(), id);
        ValidateUtil.evaluateTrue(existsCode, GeneralErrorEnum.ER000005, ValueEnum.CODE.getValue(), dto.getCode());
        Boolean existsName = this.genreRepository.existsByNameAndIdGenreNot(dto.getName(), id);
        ValidateUtil.evaluateTrue(existsName, GeneralErrorEnum.ER000005, ValueEnum.NAME.getValue(), dto.getName());
    }

    @Override
    public List<GenreDto> findAllByListIds(Collection<Integer> listIds) {
        List<GenreEntity> listEntities = this.genreRepository.findAllById(listIds);
        return this.toListDtos(listEntities);
    }

}