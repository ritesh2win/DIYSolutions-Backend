package com.diysolutions.entity.ordermanagement;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "package_details")
public class PackageDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @NotNull
    private BigDecimal deadWeight;

    @NotNull
    private BigDecimal length;

    @NotNull
    private BigDecimal breadth;

    @NotNull
    private BigDecimal height;

    @Transient
    public BigDecimal getVolumetricWeight() {
        return length.multiply(breadth).multiply(height).divide(BigDecimal.valueOf(5000), 2, BigDecimal.ROUND_HALF_UP);
    }

    @NotNull
    private BigDecimal applicableWeight;

    // Getters and Setters
}
