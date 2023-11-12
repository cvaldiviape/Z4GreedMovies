package com.catalogs.core.service.genre;

import com.catalogs.core.entity.GenreEntity;
import com.catalogs.core.entity.mapper.GenreMapper;
import com.catalogs.core.repository.GenreRepository;
import com.shared.core.service.impl.GenericCreateService;
import com.shared.dto.GenreDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("createGenreImpl")
public class CreateGenreImpl extends GenericCreateService<GenreEntity, GenreDto, Integer> {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    public CreateGenreImpl(GenreRepository genreRepository, GenreMapper genreMapper) {
        this.genreRepository = genreRepository;
        this.genreMapper = genreMapper;
    }

    @Override
    public JpaRepository<GenreEntity, Integer> getJpaRepository() {
        return this.genreRepository;
    }

    @Override
    public GenreDto toDto(GenreEntity genreEntity) {
        return this.genreMapper.toDto(genreEntity);
    }

    @Override
    public GenreEntity toEntity(GenreDto genreDto) {
        return this.genreMapper.toEntityIgnoredId(genreDto);
    }

    @Override
    public void verifyUnique(GenreDto genreDto) {
        Boolean existsCode = this.genreRepository.existsByCode(genreDto.getCode());
        Boolean existsName = this.genreRepository.existsByName(genreDto.getName());
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, genreDto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, genreDto.getName());
    }

}