package com.z4greed.core.repository;

import com.z4greed.core.models.entity.CategoryProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryProductRepository extends JpaRepository <CategoryProductEntity, Integer> {
}
