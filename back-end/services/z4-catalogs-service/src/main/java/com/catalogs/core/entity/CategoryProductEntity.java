package com.catalogs.core.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.shared.dto.custom.CommonEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "category_products")
public class CategoryProductEntity extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category_product")
    private Integer idCategoryProduct;
    @Builder.Default
    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private Set<ProductEntity> listProducts = new HashSet<>();

}