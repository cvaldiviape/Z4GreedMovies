package com.catalogs.core.repository;

import com.catalogs.core.entity.CustomerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

    @NonNull
    @Query("SELECT c FROM CustomerEntity c")
    Page<CustomerEntity> findAll(@NonNull Pageable pageable);
    Boolean existsByDni(String code);
    Boolean existsByEmail(String name);
    Boolean existsByDniAndIdCustomerNot(String code, Integer id);
    Boolean existsByEmailAndIdCustomerNot(String name, Integer id);

}