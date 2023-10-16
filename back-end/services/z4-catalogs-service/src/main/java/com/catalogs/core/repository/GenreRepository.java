package com.catalogs.core.repository;

import com.catalogs.core.entity.GenreEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

public interface GenreRepository extends JpaRepository<GenreEntity, Integer> {

    @NonNull
    @Query("SELECT c FROM GenreEntity c")
    Page<GenreEntity> findAll(@NonNull Pageable pageable);
    Boolean existsByCode(String code);
    Boolean existsByName(String name);
    Boolean existsByCodeAndIdGenreNot(String code, Integer id);
    Boolean existsByNameAndIdGenreNot(String name, Integer id);

}