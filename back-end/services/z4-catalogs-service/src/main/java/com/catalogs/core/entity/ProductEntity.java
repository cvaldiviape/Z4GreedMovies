package com.catalogs.core.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Integer idProduct;
    @Column(name = "code", length = 3, nullable = false, unique = true)
    private String code;
    @Column(name = "description", length = 255, nullable = false, unique = true)
    private String description;
    @Column(name = "price", nullable = false, precision = 5, scale = 2)
    private BigDecimal price;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_category")
    private CategoryProductEntity category;

}