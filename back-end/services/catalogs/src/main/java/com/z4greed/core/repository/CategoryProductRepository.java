package com.z4greed.core.repository;

import com.z4greed.core.models.entity.CategoryProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CategoryProductRepository extends JpaRepository <CategoryProductEntity, Integer> {

    // Define una consulta personalizada que utiliza el nombre del campo de identificación 'id_usuario'
    @Query("SELECT c FROM CategoryProductEntity c")
    Page<CategoryProductEntity> findAll(Pageable pageable);
    public Optional<CategoryProductEntity> findByCode(String code);
    public Boolean existsByCode(String code);
    public Optional<CategoryProductEntity> findByName(String name);
    public Boolean existsByName(String name);

}