package com.catalogs.core.repository;

import com.catalogs.core.entity.LanguageEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

public interface LanguageRepository extends JpaRepository<LanguageEntity, Integer> {

    @NonNull
    @Query("SELECT c FROM LanguageEntity c")
    Page<LanguageEntity> findAll(@NonNull Pageable pageable);
    Boolean existsByCode(String code);
    Boolean existsByName(String name);
    Boolean existsByCodeAndIdLanguageNot(String code, Integer id);
    Boolean existsByNameAndIdLanguageNot(String name, Integer id);

}