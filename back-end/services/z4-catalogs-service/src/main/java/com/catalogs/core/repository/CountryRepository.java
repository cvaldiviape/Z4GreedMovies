package com.catalogs.core.repository;

import com.catalogs.core.entity.CountryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

public interface CountryRepository extends JpaRepository<CountryEntity, Integer> {

    @NonNull
    @Query("SELECT c FROM CountryEntity c")
    Page<CountryEntity> findAll(@NonNull Pageable pageable);
    Boolean existsByCode(String code);
    Boolean existsByName(String name);
    Boolean existsByCodeAndIdCountryNot(String code, Integer id);
    Boolean existsByNameAndIdCountryNot(String name, Integer id);

}