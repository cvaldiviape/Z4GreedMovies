package com.ubigeo.core.repository;

import com.ubigeo.core.entity.DistrictEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

public interface DistrictRepository extends JpaRepository<DistrictEntity, Integer> {

    @NonNull
    @Query("SELECT c FROM DistrictEntity c")
    Page<DistrictEntity> findAll(@NonNull Pageable pageable);
    Boolean existsByCode(String code);
    Boolean existsByName(String name);
    Boolean existsByCodeAndIdDistrictNot(String code, Integer id);
    Boolean existsByNameAndIdDistrictNot(String name, Integer id);

}