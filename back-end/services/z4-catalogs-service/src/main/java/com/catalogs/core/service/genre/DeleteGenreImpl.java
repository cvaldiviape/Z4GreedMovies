package com.catalogs.core.service.genre;

import com.catalogs.core.entity.GenreEntity;
import com.catalogs.core.entity.mapper.GenreMapper;
import com.catalogs.core.repository.GenreRepository;
import com.shared.core.service.impl.GenericDeleteService;
import com.shared.dto.GenreDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("deleteGenreImpl")
public class DeleteGenreImpl extends GenericDeleteService<GenreEntity, GenreDto, Integer> {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    public DeleteGenreImpl(GenreRepository genreRepository, GenreMapper genreMapper) {
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
    public GenreEntity findEntityById(Integer idGenre) {
        return this.genreRepository.findById(idGenre)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.GENRE.getValue(), idGenre));
    }

}