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
@Table(name = "profit_agreements")
public class ProfitAgreementsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_profit_agreements")
    private Integer idProfitAgreements;
    @Column(name = "studio", nullable = false, precision = 5, scale = 2)
    private BigDecimal studio;
    @Column(name = "house", nullable = false, precision = 5, scale = 2)
    private BigDecimal house;

}