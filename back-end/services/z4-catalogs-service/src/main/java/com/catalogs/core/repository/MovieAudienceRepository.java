package com.catalogs.core.repository;

import com.catalogs.core.entity.MovieAudienceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

public interface MovieAudienceRepository extends JpaRepository<MovieAudienceEntity, Integer> {

    @NonNull
    @Query("SELECT c FROM MovieAudienceEntity c")
    Page<MovieAudienceEntity> findAll(@NonNull Pageable pageable);
    Boolean existsByCode(String code);
    Boolean existsByName(String name);
    Boolean existsByCodeAndIdMovieAudienceNot(String code, Integer id);
    Boolean existsByNameAndIdMovieAudienceNot(String name, Integer id);

}