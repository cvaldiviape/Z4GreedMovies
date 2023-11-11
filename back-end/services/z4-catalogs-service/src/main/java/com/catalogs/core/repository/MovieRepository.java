package com.catalogs.core.repository;

import com.catalogs.core.entity.MovieEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

public interface MovieRepository  extends JpaRepository<MovieEntity, Integer> {

    @NonNull
    @Query("SELECT c FROM MovieEntity c")
    Page<MovieEntity> findAll(@NonNull Pageable pageable);
    Boolean existsByCode(String code);
    Boolean existsByCodeAndIdMovieNot(String code, Integer id);

}