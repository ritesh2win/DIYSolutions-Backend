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
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @NotNull
    @Column(length = 255)
    private String productName;

    @Column(length = 20)
    private String hsnCode;

    @NotNull
    private BigDecimal unitPrice;

    @NotNull
    private Integer quantity;

    private BigDecimal discount = BigDecimal.ZERO;

    private BigDecimal taxRate = BigDecimal.ZERO;

}
