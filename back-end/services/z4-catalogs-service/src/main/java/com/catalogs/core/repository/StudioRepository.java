package com.catalogs.core.repository;

import com.catalogs.core.entity.StudioEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

public interface StudioRepository extends JpaRepository<StudioEntity, Integer> {

    @NonNull
    @Query("SELECT c FROM StudioEntity c")
    Page<StudioEntity> findAll(@NonNull Pageable pageable);
    Boolean existsByCode(String code);
    Boolean existsByName(String name);
    Boolean existsByCodeAndIdStudioNot(String code, Integer id);
    Boolean existsByNameAndIdStudioNot(String name, Integer id);

}