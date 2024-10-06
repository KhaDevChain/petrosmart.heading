package com.factory.heading.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.factory.heading.models.Permisstion;

@Repository
public interface PermissionRepo extends JpaRepository<Permisstion, String> {
    
}
