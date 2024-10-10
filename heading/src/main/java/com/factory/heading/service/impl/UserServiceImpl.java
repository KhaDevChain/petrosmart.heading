package com.factory.heading.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.factory.heading.models.User;
import com.factory.heading.repository.UserRepo;
import com.factory.heading.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public User save(User user) {
        userRepo.save(user);
        return user;
    }

    @Override
    public User findById(String uniqueId) {
        return userRepo.findById(uniqueId).orElse(null);
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username).orElse(null);
    }

    @Override
    public User findBySKU(String sku) {
        return userRepo.findBySKU(sku).orElse(null);
    }

    @Override
    public List<User> getAccounts() {
        return userRepo.findAll();
    }

    @Override
    public List<User> findByFullnameLike(String character) {
        return userRepo.findByFullnameLike(character);
    }

    @Override
    public Page<User> getAccounts(Pageable pageable) {
        return userRepo.findAll(pageable);
    }

    @Override
    public Page<User> getAccounts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepo.findAll(pageable);
    }
    
}
