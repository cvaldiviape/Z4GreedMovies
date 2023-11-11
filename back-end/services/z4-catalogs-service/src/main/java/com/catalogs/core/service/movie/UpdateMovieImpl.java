package com.catalogs.core.service.movie;

import com.catalogs.core.entity.*;
import com.catalogs.core.entity.mapper.*;
import com.catalogs.core.repository.*;
import com.shared.core.service.UpdateService;
import com.shared.dto.*;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service("updateMovieImpl")
@Transactional
public class UpdateMovieImpl implements UpdateService<MovieDto, Integer> {

    private final MovieRepository movieRepository;
    private final StudioRepository studioRepository;
    private final MovieAudienceRepository movieAudienceRepository;
    private final GenreRepository genreRepository;
    private final LanguageRepository languageRepository;
    private final MovieMapper movieMapper;
    private final StudioMapper studioMapper;
    private final MovieAudienceMapper movieAudienceMapper;
    private final GenreMapper genreMapper;
    private final LanguageMapper languageMapper;

    public UpdateMovieImpl(
            MovieRepository movieRepository,
            StudioRepository studioRepository,
            MovieAudienceRepository movieAudienceRepository,
            GenreRepository genreRepository,
            LanguageRepository languageRepository,
            MovieMapper movieMapper,
            StudioMapper studioMapper,
            MovieAudienceMapper movieAudienceMapper,
            GenreMapper genreMapper,
            LanguageMapper languageMapper
    ) {
        this.movieRepository = movieRepository;
        this.studioRepository = studioRepository;
        this.movieAudienceRepository = movieAudienceRepository;
        this.genreRepository = genreRepository;
        this.languageRepository = languageRepository;
        this.movieMapper = movieMapper;
        this.studioMapper = studioMapper;
        this.movieAudienceMapper = movieAudienceMapper;
        this.genreMapper = genreMapper;
        this.languageMapper = languageMapper;
    }

    @Override
    public MovieDto update(Integer idMovie, MovieDto movieDto) {
        MovieEntity movieEntity = this.findMovieEntityById(idMovie);
        this.validateUniqueFields(idMovie, movieDto);
        this.setComplementaryData(movieDto);
        movieEntity.setStudio(null);
        movieEntity.setMovieAudience(null);
        movieEntity.setProfitAgreements(null);
        movieEntity.getListGenres().clear();
        movieEntity.getListLanguages().clear();
        this.movieMapper.updateEntityFromDtoIgnoredId(movieDto, movieEntity);

        MovieEntity movieUpdated = this.movieRepository.save(movieEntity);
        return this.movieMapper.toDto(movieUpdated);
    }

    // ------------------------------------------------------------------------- utils ------------------------------------------------------------------------- //
    private MovieEntity findMovieEntityById(Integer idMovie) {
        return this.movieRepository.findById(idMovie)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.MOVIE.getValue(), idMovie));
    }

    private void validateUniqueFields(Integer id, MovieDto movieDto) {
        Boolean existsCode = this.movieRepository.existsByCodeAndIdMovieNot(movieDto.getCode(), id);
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, movieDto.getCode());
    }

    private void setComplementaryData(MovieDto movieDto) {
        Integer idStudio = movieDto.getStudio().getIdStudio();
        StudioEntity studioEntity = this.findStudioEntityById(idStudio);

        Integer idMovieAudience = movieDto.getMovieAudience().getIdMovieAudience();
        MovieAudienceEntity movieAudienceEntity = this.findMovieAudienceEntityById(idMovieAudience);

        Set<GenreEntity> listGenresEntities = movieDto.getListGenres()
                .stream()
                .map(genre -> this.findGenreEntityById(genre.getIdGenre()))
                .collect(Collectors.toSet());

        Set<LanguageEntity> listLanguagesEntities = movieDto.getListLanguages()
                .stream()
                .map(language -> this.findLanguageEntityById(language.getIdLanguage()))
                .collect(Collectors.toSet());

        StudioDto studioDto = this.studioMapper.toDto(studioEntity);
        movieDto.setStudio(studioDto);
        MovieAudienceDto movieAudienceDto = this.movieAudienceMapper.toDto(movieAudienceEntity);
        movieDto.setMovieAudience(movieAudienceDto);
        Collection<GenreDto> listGenresDtos = this.genreMapper.toListDtos(listGenresEntities);
        movieDto.setListGenres(new HashSet<>(listGenresDtos));
        Collection<LanguageDto> listLanguagesDtos = this.languageMapper.toListDtos(listLanguagesEntities);
        movieDto.setListLanguages(new HashSet<>(listLanguagesDtos));
    }

    private StudioEntity findStudioEntityById(Integer idStudio) {
        return this.studioRepository.findById(idStudio)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.STUDIO.getValue(), idStudio));
    }

    private MovieAudienceEntity findMovieAudienceEntityById(Integer idMovieAudience) {
        return this.movieAudienceRepository.findById(idMovieAudience)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.AUDIENCE.getValue(), idMovieAudience));
    }

    private GenreEntity findGenreEntityById(Integer idGenre) {
        return this.genreRepository.findById(idGenre)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.GENRE.getValue(), idGenre));
    }

    private LanguageEntity findLanguageEntityById(Integer idLanguage) {
        return this.languageRepository.findById(idLanguage)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.LANGUAGE.getValue(), idLanguage));
    }

}