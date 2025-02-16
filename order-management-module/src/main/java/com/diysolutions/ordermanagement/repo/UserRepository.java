package com.diysolutions.ordermanagement.repo;


 import com.diysolutions.entity.ordermanagement.User;
 import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
