package com.diysolutions.ordermanagement.repo;

 import com.diysolutions.entity.ordermanagement.Order;
 import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByTrackingNumber(String trackingNumber);
}
