package com.ubigeo.core.repository;

import com.ubigeo.core.entity.ProvinceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

public interface ProvinceRepository extends JpaRepository<ProvinceEntity, Integer> {

    @NonNull
    @Query("SELECT c FROM ProvinceEntity c")
    Page<ProvinceEntity> findAll(@NonNull Pageable pageable);
    Boolean existsByCode(String code);
    Boolean existsByName(String name);
    Boolean existsByCodeAndIdProvinceNot(String code, Integer id);
    Boolean existsByNameAndIdProvinceNot(String name, Integer id);

}