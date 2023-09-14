package com.z4greed.core.service.impl;

import com.z4greed.core.models.dto.MovieAudienceDto;
import com.z4greed.core.models.entity.MovieAudienceEntity;
import com.z4greed.core.models.mapper.MovieAudienceMapper;
import com.z4greed.core.repository.MovieAudienceRepository;
import com.z4greed.core.service.MovieAudienceService;
import com.z4greed.shared.exception.ResourceNotFoundException;
import com.z4greed.shared.utils.ValidateUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
    public void updateEntityFromDto(MovieAudienceDto dto, MovieAudienceEntity entity) {
        this.movieAudienceMapper.updateEntityFromDto(dto, entity);
    }

    @Override
    public MovieAudienceEntity findEntityById(Integer id) {
        return this.movieAudienceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id", id));
    }

    @Override
    public void verifyUnique(MovieAudienceDto dto) {
        Boolean existsCode = this.movieAudienceRepository.existsByCode(dto.getCode());
        ValidateUtil.evaluate(existsCode, "The code " + dto.getCode() + " already exists.");
        Boolean existsName = this.movieAudienceRepository.existsByName(dto.getName());
        ValidateUtil.evaluate(existsName, "The name " + dto.getName() + " already exists.");
    }

    @Override
    public void verifyUnique(Integer id, MovieAudienceDto dto) {
        Boolean existsCode = this.movieAudienceRepository.existsByCodeAndIdMovieAudienceNot(dto.getCode(), id);
        ValidateUtil.evaluate(existsCode, "The code " + dto.getCode() + " already exists.");
        Boolean existsName = this.movieAudienceRepository.existsByNameAndIdMovieAudienceNot(dto.getName(), id);
        ValidateUtil.evaluate(existsName, "The name " + dto.getName() + " already exists.");
    }

    @Override
    public List<MovieAudienceDto> findAllByListIds(Collection<Integer> listIds) {
        List<MovieAudienceEntity> listEntities = this.movieAudienceRepository.findAllById(listIds);
        return  listEntities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

}