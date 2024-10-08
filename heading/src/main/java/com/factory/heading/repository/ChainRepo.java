package com.factory.heading.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.factory.heading.models.Chain;

@Repository
public interface ChainRepo extends JpaRepository<Chain, String> {
    @Query("SELECT o FROM Chain o WHERE o.SKU=:sku")
    Optional<Chain> findBySKU(String sku);

    @Query("SELECT o FROM Chain o WHERE o.ChainName LIKE %:character%")
    List<Chain> findByChainNameContaining(String character);
}
