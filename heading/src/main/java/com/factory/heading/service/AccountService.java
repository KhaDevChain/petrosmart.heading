package com.factory.heading.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.factory.heading.models.Account;

public interface AccountService {
    // List
    List<Account> getAccounts();
    List<Account> getAccountNameLike(String accountName);

    // Pagination
    Page<Account> getAccounts(Pageable pageable);
    Page<Account> getAccounts(int page, int size);
    Page<Account> getAccountNameLike(String accountName, int page, int size);

    // Object
    Account findById(String uniqueId);
    Account findByTaxOrPhone(String tax, String phone);
    Account findBySKU(String sku);
}
