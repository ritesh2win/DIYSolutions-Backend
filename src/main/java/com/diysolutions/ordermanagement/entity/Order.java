package com.diysolutions.ordermanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.List;

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

    public enum OrderType {
        DOMESTIC, INTERNATIONAL
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public PackageDetail getPackageDetail() {
        return packageDetail;
    }

    public void setPackageDetail(PackageDetail packageDetail) {
        this.packageDetail = packageDetail;
    }

    public OrderType getOrderType() { return orderType; }
    public void setOrderType(OrderType orderType) { this.orderType = orderType; }

    public String getPickupAddress() { return pickupAddress; }
    public void setPickupAddress(String pickupAddress) { this.pickupAddress = pickupAddress; }

    public String getDeliveryMobile() { return deliveryMobile; }
    public void setDeliveryMobile(String deliveryMobile) { this.deliveryMobile = deliveryMobile; }

    public String getDeliveryName() { return deliveryName; }
    public void setDeliveryName(String deliveryName) { this.deliveryName = deliveryName; }

    public String getDeliveryAddress() { return deliveryAddress; }
    public void setDeliveryAddress(String deliveryAddress) { this.deliveryAddress = deliveryAddress; }

    public String getLandmark() { return landmark; }
    public void setLandmark(String landmark) { this.landmark = landmark; }

    public String getPincode() { return pincode; }
    public void setPincode(String pincode) { this.pincode = pincode; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getAlternateMobile() { return alternateMobile; }
    public void setAlternateMobile(String alternateMobile) { this.alternateMobile = alternateMobile; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Boolean getBillingSameAsDelivery() { return billingSameAsDelivery; }
    public void setBillingSameAsDelivery(Boolean billingSameAsDelivery) { this.billingSameAsDelivery = billingSameAsDelivery; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}
