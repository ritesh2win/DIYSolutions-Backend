package com.diysolutions.entity.ordermanagement;

import com.diysolutions.enums.OrderType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String trackingNumber;

    @Enumerated(EnumType.STRING)
    @NotNull
    private OrderType orderType;

    @NotNull
    @Column(columnDefinition = "TEXT")
    private String pickupAddress;

    @NotNull
    @Column(length = 15)
    private String deliveryMobile;

    @NotNull
    @Column(length = 100)
    private String deliveryName;

    @NotNull
    @Column(columnDefinition = "TEXT")
    private String deliveryAddress;

    private String landmark;

    @NotNull
    @Column(length = 10)
    private String pincode;

    @NotNull
    @Column(length = 100)
    private String city;

    @NotNull
    @Column(length = 100)
    private String state;

    @Column(length = 15)
    private String alternateMobile;

    @Column(length = 100)
    private String email;

    @NotNull
    private Boolean billingSameAsDelivery = true;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Payment payment;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private PackageDetail packageDetail;



}
