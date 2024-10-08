package com.factory.heading.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.factory.heading.models.User;

public interface UserService {
    //OBJECT
    User findById(String uniqueId);
    User findByUsername(String username);
    User findBySKU(String sku);

    // LIST
    List<User> getAccounts();
    List<User> findByFullnameLike(String character);

    Page<User> getAccounts(Pageable pageable);
    Page<User> getAccounts(int page, int size);
}
