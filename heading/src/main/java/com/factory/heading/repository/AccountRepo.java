package com.factory.heading.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.factory.heading.models.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, String> {
    // LIST
    List<Account> findByAccountNameLike(String key);

    // PAGE
    Page<Account> findByNameContaining(String name, Pageable pageable);

    // OBJECT
    @Query("SELECT o FROM Account o WHERE o.Tax = ?1 OR o.Phone = ?2")
    Account findByTaxOrPhone(String tax, String phone);

    @Query("SELECT o FROM Account o WHERE o.SKU = ?1")
    Account findBySKU(String sku);
}
