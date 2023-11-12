package com.catalogs.core.service.genre;

import com.catalogs.core.entity.GenreEntity;
import com.catalogs.core.entity.mapper.GenreMapper;
import com.catalogs.core.repository.GenreRepository;
import com.shared.core.service.impl.GenericUpdateService;
import com.shared.dto.GenreDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("updateGenreImpl")
public class UpdateGenreImpl  extends GenericUpdateService<GenreEntity, GenreDto, Integer> {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    public UpdateGenreImpl(GenreRepository genreRepository, GenreMapper genreMapper) {
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
    public void updateEntityFromDto(GenreDto genreDto, GenreEntity genreEntity) {
        this.genreMapper.updateEntityFromDtoIgnoredId(genreDto, genreEntity);
    }

    @Override
    public GenreEntity findEntityById(Integer idGenre) {
        return this.genreRepository.findById(idGenre)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.COUNTRY.getValue(), idGenre));
    }

    @Override
    public void verifyUnique(Integer idGenre, GenreDto genreDto) {
        Boolean existsCode = this.genreRepository.existsByCodeAndIdGenreNot(genreDto.getCode(), idGenre);
        Boolean existsName = this.genreRepository.existsByNameAndIdGenreNot(genreDto.getName(), idGenre);
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, genreDto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, genreDto.getName());
    }

}