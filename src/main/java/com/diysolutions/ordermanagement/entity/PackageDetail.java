package com.diysolutions.ordermanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

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
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }

    public BigDecimal getDeadWeight() { return deadWeight; }
    public void setDeadWeight(BigDecimal deadWeight) { this.deadWeight = deadWeight; }

    public BigDecimal getLength() { return length; }
    public void setLength(BigDecimal length) { this.length = length; }

    public BigDecimal getBreadth() { return breadth; }
    public void setBreadth(BigDecimal breadth) { this.breadth = breadth; }

    public BigDecimal getHeight() { return height; }
    public void setHeight(BigDecimal height) { this.height = height; }

    public BigDecimal getApplicableWeight() { return applicableWeight; }
    public void setApplicableWeight(BigDecimal applicableWeight) { this.applicableWeight = applicableWeight; }
}
