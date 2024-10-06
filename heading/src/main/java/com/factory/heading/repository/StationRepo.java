package com.factory.heading.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.factory.heading.models.Station;

@Repository
public interface StationRepo extends JpaRepository<Station, String> {
    
}
