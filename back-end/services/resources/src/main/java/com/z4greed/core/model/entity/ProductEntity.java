package com.z4greed.core.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import java.math.BigDecimal;
import java.util.Objects;

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
    @Column(length = 3, nullable = false, unique = true)
    private String code;
    @Column(length = 50, nullable = false, unique = true)
    private String description;
    @Column(precision = 22, scale = 6, nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private Integer stock;
    @Column(name = "id_category_product", nullable = false)
    private Integer idCategoryProduct;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductEntity that = (ProductEntity) o;
        return idProduct != null && Objects.equals(idProduct, that.idProduct);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}