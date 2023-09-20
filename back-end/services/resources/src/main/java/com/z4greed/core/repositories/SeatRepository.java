package com.z4greed.core.repositories;

import com.z4greed.core.model.entity.SeatEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

public interface SeatRepository extends JpaRepository<SeatEntity, Integer> {

    @NonNull
    @Query("SELECT c FROM SeatEntity c")
    Page<SeatEntity> findAll(@NonNull Pageable pageable);
    Boolean existsByCode(String code);
    Boolean existsByCodeAndIdSeatNot(String code, Integer id);

}