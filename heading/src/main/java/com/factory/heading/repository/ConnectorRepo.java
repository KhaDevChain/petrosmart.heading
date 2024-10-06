package com.factory.heading.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.factory.heading.models.Connector;

@Repository
public interface ConnectorRepo extends JpaRepository<Connector, String> {
    
}
