package com.factory.heading.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.factory.heading.models.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    
}
