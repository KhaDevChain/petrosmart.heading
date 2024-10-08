package com.factory.heading.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.factory.heading.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    @Query("SELECT o FROM User o WHERE o.Username=:username")
    Optional<User> findByUsername(String username);

    @Query("SELECT o FROM User o WHERE o.SKU=:sku")
    Optional<User> findBySKU(String sku);

    @Query("SELECT o FROM User o WHERE o.Fullname LIKE %:character%")
    List<User> findByFullnameLike(String character);
}
