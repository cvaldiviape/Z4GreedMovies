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
    Boolean existsByCode(String code);
    Boolean existsByName(String name);
    Boolean existsByCodeAndIdCategoryProductNot(String code, Integer idCategoryProduct);
    Boolean existsByNameAndIdCategoryProductNot(String name, Integer idCategoryProduct);

}