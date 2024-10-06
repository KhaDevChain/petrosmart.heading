package com.factory.heading.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.factory.heading.models.Status;

@Repository
public interface StatusRepo extends JpaRepository<Status, Integer> {
    
}
