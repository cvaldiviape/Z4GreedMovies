package com.catalogs.core.repository;

import com.catalogs.core.entity.TypeStatusFilmShowEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

public interface TypeStatusFilmShowRepository  extends JpaRepository<TypeStatusFilmShowEntity, Integer> {

    @NonNull
    @Query("SELECT c FROM TypeStatusFilmShowEntity c")
    Page<TypeStatusFilmShowEntity> findAll(@NonNull Pageable pageable);
    Boolean existsByCode(String code);
    Boolean existsByName(String name);
    Boolean existsByCodeAndIdTypeStatusFilmShowNot(String code, Integer id);
    Boolean existsByNameAndIdTypeStatusFilmShowNot(String name, Integer id);

}