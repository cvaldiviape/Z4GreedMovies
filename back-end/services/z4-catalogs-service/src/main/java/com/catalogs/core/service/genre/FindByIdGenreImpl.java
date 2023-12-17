package com.catalogs.core.service.genre;

import com.catalogs.core.entity.GenreEntity;
import com.catalogs.core.entity.mapper.GenreMapper;
import com.catalogs.core.repository.GenreRepository;
import com.shared.core.service.impl.GenericFindByIdService;
import com.shared.dto.external.catalogs.GenreDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.stereotype.Service;

@Service("findByIdGenreImpl")
public class FindByIdGenreImpl extends GenericFindByIdService<GenreEntity, GenreDto, Integer> {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    public FindByIdGenreImpl(GenreRepository genreRepository, GenreMapper genreMapper) {
        this.genreRepository = genreRepository;
        this.genreMapper = genreMapper;
    }

    @Override
    public GenreDto toDto(GenreEntity genreEntity) {
        return this.genreMapper.toDto(genreEntity);
    }

    @Override
    public GenreEntity findEntityById(Integer idGenre) {
        return this.genreRepository.findById(idGenre)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.GENRE.getValue(), idGenre));
    }

}