package com.catalogs.core.service.genre;

import com.catalogs.core.entity.GenreEntity;
import com.catalogs.core.entity.mapper.GenreMapper;
import com.catalogs.core.repository.GenreRepository;
import com.shared.core.service.impl.GenericFindAllService;
import com.shared.dto.external.catalogs.GenreDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service("findAllGenreImpl")
public class FindAllGenreImpl extends GenericFindAllService<GenreEntity, GenreDto, Integer> {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    public FindAllGenreImpl(GenreRepository genreRepository, GenreMapper genreMapper) {
        this.genreRepository = genreRepository;
        this.genreMapper = genreMapper;
    }

    @Override
    public JpaRepository<GenreEntity, Integer> getJpaRepository() {
        return this.genreRepository;
    }

    @Override
    public Collection<GenreDto> toListDtos(Collection<GenreEntity> listEntities) {
        return this.genreMapper.toListDtos(listEntities);
    }

}