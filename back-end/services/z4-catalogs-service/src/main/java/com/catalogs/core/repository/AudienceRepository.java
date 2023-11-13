package com.catalogs.core.repository;

import com.catalogs.core.entity.AudienceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

public interface AudienceRepository extends JpaRepository<AudienceEntity, Integer> {

    @NonNull
    @Query("SELECT c FROM AudienceEntity c")
    Page<AudienceEntity> findAll(@NonNull Pageable pageable);
    Boolean existsByCode(String code);
    Boolean existsByName(String name);
    Boolean existsByCodeAndIdAudienceNot(String code, Integer id);
    Boolean existsByNameAndIdAudienceNot(String name, Integer id);

}