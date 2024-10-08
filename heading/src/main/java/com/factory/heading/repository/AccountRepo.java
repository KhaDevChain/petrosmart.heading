package com.factory.heading.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.factory.heading.models.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, String> {
    @Query("SELECT o FROM Account o WHERE o.Tax=:tax OR o.Phone=:phone")
    Optional<Account> findByTaxOrPhone(String tax, String phone);

    @Query("SELECT o FROM Account o WHERE o.SKU=:sku")
    Optional<Account> findBySKU(String sku);

    @Query("SELECT o FROM Account o WHERE o.AccountName LIKE %:key%")
    List<Account> findByAccountNameContaining(String key);

    @Query("SELECT o FROM Account o WHERE o.AccountName LIKE %:name%")
    Page<Account> findByAccountNameContaining(String name, Pageable pageable);
}
