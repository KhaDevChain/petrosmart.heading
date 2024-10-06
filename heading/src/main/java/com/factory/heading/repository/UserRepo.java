package com.factory.heading.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.factory.heading.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    
}
