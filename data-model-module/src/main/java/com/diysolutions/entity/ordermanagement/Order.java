package com.diysolutions.entity.ordermanagement;

import com.diysolutions.enums.OrderType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.math.BigDecimal;
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
    private String orderId; // CSV: *Order Id

    @CreationTimestamp
    private LocalDateTime orderDate; // CSV: Order Date as dd-mm-yyyy hh:MM

    @NotNull
    @Column(length = 100)
    private String channel; // CSV: *Channel

    @NotNull
    @Column(length = 50)
    private String paymentMethod; // CSV: *Payment Method(COD/Prepaid)

    @NotNull
    @Column(length = 100)
    private String customerFirstName; // CSV: *Customer First Name

    @Column(length = 100)
    private String customerLastName; // CSV: Customer Last Name

    @Column(length = 100)
    private String email; // CSV: Email (Optional)

    @NotNull
    @Column(length = 15)
    private String customerMobile; // CSV: *Customer Mobile

    @Column(length = 15)
    private String alternateMobile; // CSV: Customer Alternate Mobile

    @NotNull
    @Column(columnDefinition = "TEXT")
    private String shippingAddressLine1; // CSV: *Shipping Address Line 1

    @Column(columnDefinition = "TEXT")
    private String shippingAddressLine2; // CSV: Shipping Address Line 2

    @NotNull
    @Column(length = 100)
    private String shippingCountry; // CSV: *Shipping Address Country

    @NotNull
    @Column(length = 100)
    private String shippingState; // CSV: *Shipping Address State

    @NotNull
    @Column(length = 100)
    private String shippingCity; // CSV: *Shipping Address City

    @NotNull
    @Column(length = 10)
    private String shippingPostcode; // CSV: *Shipping Address Postcode

    private String billingAddressLine1; // CSV: Billing Address Line 1

    private String billingAddressLine2; // CSV: Billing Address Line 2

    private String billingCountry; // CSV: Billing Address Country

    private String billingState; // CSV: Billing Address State

    private String billingCity; // CSV: Billing Address City

    private String billingPostcode; // CSV: Billing Address Postcode

    @NotNull
    @Column(length = 50)
    private String masterSKU; // CSV: *Master SKU

    @NotNull
    @Column(length = 255)
    private String productName; // CSV: *Product Name

    @NotNull
    private Integer productQuantity; // CSV: *Product Quantity

    private BigDecimal taxPercentage; // CSV: Tax %

    @NotNull
    private BigDecimal sellingPrice; // CSV: *Selling Price(Per Unit Item, Inclusive of Tax)

    private BigDecimal discount; // CSV: Discount(Per Unit Item)

    private BigDecimal shippingCharges; // CSV: Shipping Charges(Per Order)

    private BigDecimal codCharges; // CSV: COD Charges(Per Order)

    private BigDecimal giftWrapCharges; // CSV: Gift Wrap Charges(Per Order)

    private BigDecimal totalDiscount; // CSV: Total Discount (Per Order)

    @NotNull
    private Double length; // CSV: *Length (cm)

    @NotNull
    private Double breadth; // CSV: *Breadth (cm)

    @NotNull
    private Double height; // CSV: *Height (cm)

    @NotNull
    private Double weight; // CSV: *Weight Of Shipment(kg)

    private Boolean sendNotification; // CSV: Send Notification(True/False)

    private String comment; // CSV: Comment

    private String hsnCode; // CSV: HSN Code

    private String locationId; // CSV: Location ID

    private String resellerName; // CSV: Reseller Name

    private String companyName; // CSV: Company Name

    private Double latitude; // CSV: latitude

    private Double longitude; // CSV: longitude

    private Boolean verifiedOrder; // CSV: Verified Order

    private Boolean isDocuments; // CSV: Is documents

    @Enumerated(EnumType.STRING)
    @NotNull
    private OrderType orderType; // CSV: Order Type

    private String orderTag; // CSV: Order tag

    private Integer fulfillmentTat; // CSV: Fulfillment Tat

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
