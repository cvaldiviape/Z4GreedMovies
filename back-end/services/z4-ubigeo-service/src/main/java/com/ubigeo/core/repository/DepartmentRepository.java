package com.ubigeo.core.repository;

import com.ubigeo.core.entity.DepartmentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer> {

    @NonNull
    @Query("SELECT c FROM DepartmentEntity c")
    Page<DepartmentEntity> findAll(@NonNull Pageable pageable);
    Boolean existsByCode(String code);
    Boolean existsByName(String name);
    Boolean existsByCodeAndIdDepartmentNot(String code, Integer id);
    Boolean existsByNameAndIdDepartmentNot(String name, Integer id);

}