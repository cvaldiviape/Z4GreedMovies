package com.z4greed.core.service.impl;

import com.shared.dto.MovieAudienceDto;
import com.shared.enums.ValueEnum;
import com.shared.error.GeneralErrorEnum;
import com.shared.utils.ValidateUtil;
import com.z4greed.core.entity.MovieAudienceEntity;
import com.z4greed.core.entity.mapper.MovieAudienceMapper;
import com.z4greed.core.repository.MovieAudienceRepository;
import com.z4greed.core.service.MovieAudienceService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.List;

@Service("movieAudienceServiceImpl")
@Transactional
public class MovieAudienceServiceImpl extends MovieAudienceService<MovieAudienceEntity, MovieAudienceDto, Integer> {

    private final MovieAudienceRepository movieAudienceRepository;
    private final MovieAudienceMapper movieAudienceMapper;

    public MovieAudienceServiceImpl(MovieAudienceRepository movieAudienceRepository, MovieAudienceMapper movieAudienceMapper) {
        this.movieAudienceRepository = movieAudienceRepository;
        this.movieAudienceMapper = movieAudienceMapper;
    }

    @Override
    public JpaRepository<MovieAudienceEntity, Integer> getJpaRepository() {
        return this.movieAudienceRepository;
    }

    @Override
    public MovieAudienceDto toDto(MovieAudienceEntity entity) {
        return this.movieAudienceMapper.toDto(entity);
    }

    @Override
    public MovieAudienceEntity toEntity(MovieAudienceDto dto) {
        return this.movieAudienceMapper.toEntity(dto);
    }

    @Override
    public List<MovieAudienceDto> toListDtos(List<MovieAudienceEntity> listEntities) {
        return this.movieAudienceMapper.toListDtos(listEntities);
    }

    @Override
    public void updateEntityFromDto(MovieAudienceDto dto, MovieAudienceEntity entity) {
        this.movieAudienceMapper.updateEntityFromDto(dto, entity);
    }

    @Override
    public MovieAudienceEntity findEntityById(Integer id) {
        return this.movieAudienceRepository.findById(id)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.AUDIENCE.getValue(), id));
    }

    @Override
    public void verifyUnique(MovieAudienceDto dto) {
        Boolean existsCode = this.movieAudienceRepository.existsByCode(dto.getCode());
        Boolean existsName = this.movieAudienceRepository.existsByName(dto.getName());
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, dto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, dto.getName());
    }

    @Override
    public void verifyUnique(Integer id, MovieAudienceDto dto) {
        Boolean existsCode = this.movieAudienceRepository.existsByCodeAndIdMovieAudienceNot(dto.getCode(), id);
        Boolean existsName = this.movieAudienceRepository.existsByNameAndIdMovieAudienceNot(dto.getName(), id);
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, dto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, dto.getName());
    }

    @Override
    public List<MovieAudienceDto> findAllByListIds(Collection<Integer> listIds) {
        List<MovieAudienceEntity> listEntities = this.movieAudienceRepository.findAllById(listIds);
        return this.toListDtos(listEntities);
    }

}