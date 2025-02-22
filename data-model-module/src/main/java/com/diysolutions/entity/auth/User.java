package com.diysolutions.entity.auth;


import com.diysolutions.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String fullName;


    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    private Role role;

    @CreationTimestamp
    @Column(updatable = false, nullable = false, name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

//    @Column(nullable = false)
//    private boolean accountNonExpired = true;
//
//    @Column(nullable = false)
//    private boolean accountNonLocked = true;
//
//    @Column(nullable = false)
//    private boolean credentialsNonExpired = true;
//
//    @Column(nullable = false)
//    private boolean enabled = true;

    @Override
    public List<SimpleGrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.getName()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        // Example logic: Account expires if it was created more than a year ago
        return createdAt.isAfter(LocalDateTime.now().minusYears(1));
    }

    @Override
    public boolean isAccountNonLocked() {
        // Example logic: Check if the user is locked (you can add more complex rules)
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Example logic: Password expires after 90 days
        return updatedAt.isAfter(LocalDateTime.now().minusDays(90));
    }

    @Override
    public boolean isEnabled() {
        // Example logic: Enable user only if they are verified (email verified etc.)
        return true;
    }
}
