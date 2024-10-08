package com.factory.heading.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.factory.heading.models.Account;
import com.factory.heading.repository.AccountRepo;
import com.factory.heading.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo accountRepo;

    @Override
    public List<Account> getAccounts() {
        return accountRepo.findAll();
    }

    @Override
    public List<Account> getAccountNameLike(String accountName) {
        return accountRepo.findByAccountNameContaining(accountName);
    }

    @Override
    public Page<Account> getAccounts(Pageable pageable) {
        return accountRepo.findAll(pageable);
    }

    @Override
    public Page<Account> getAccounts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return accountRepo.findAll(pageable);
    }

    @Override
    public Page<Account> getAccountNameLike(String accountName, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return accountRepo.findByAccountNameContaining(accountName, pageable);
    }

    @Override
    public Account findById(String uniqueId) {
        return accountRepo.findById(uniqueId).orElse(null);
    }

    @Override
    public Account findByTaxOrPhone(String tax, String phone) {
        return accountRepo.findByTaxOrPhone(tax, phone).orElse(null);
    }

    @Override
    public Account findBySKU(String sku) {
        return accountRepo.findBySKU(sku).orElse(null);
    }
}
