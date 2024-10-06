package com.factory.heading.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.factory.heading.models.Chain;

@Repository
public interface ChainRepo extends JpaRepository<Chain, String> {
    // OBJECT
    Chain findBySKU(String sku);

    // LIST
    List<Chain> findByChainNameLike(String character);
}
