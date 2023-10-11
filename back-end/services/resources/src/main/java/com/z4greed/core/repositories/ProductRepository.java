package com.z4greed.core.repositories;

import com.z4greed.core.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    @NonNull
    @Query("SELECT c FROM ProductEntity c")
    Page<ProductEntity> findAll(@NonNull Pageable pageable);
    Boolean existsByCode(String code);
    Boolean existsByCodeAndIdProductNot(String code, Integer id);
    Boolean existsByDescription(String code);
    Boolean existsByDescriptionAndIdProductNot(String code, Integer id);

}