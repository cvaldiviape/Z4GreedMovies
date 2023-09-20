package com.z4greed.core.repositories;

import com.z4greed.core.model.entity.RoomEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

public interface RoomRespository extends JpaRepository<RoomEntity,Integer> {

    @NonNull
    @Query("SELECT c FROM RoomEntity c")
    Page<RoomEntity> findAll(@NonNull Pageable pageable);
    Boolean existsByCode(String code);
    Boolean existsByCodeAndIdRoomNot(String code, Integer id);

}