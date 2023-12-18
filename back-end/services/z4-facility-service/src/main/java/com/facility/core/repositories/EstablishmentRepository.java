package com.facility.core.repositories;

import com.facility.core.entity.EstablishmentEntity;
import com.facility.core.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

public interface EstablishmentRepository  extends JpaRepository<EstablishmentEntity, Integer> {

    @NonNull
    @Query("SELECT c FROM EstablishmentEntity c")
    Page<EstablishmentEntity> findAll(@NonNull Pageable pageable);
    Boolean existsByCode(String code);
    Boolean existsByCodeAndEstablishmentNot(String code, Integer id);

}