package com.factory.heading.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.factory.heading.models.Station;

@Repository
public interface StationRepo extends JpaRepository<Station, String> {
    @Query("SELECT o FROM Station o WHERE o.Tax=:tax")
    Optional<Station> findByTax(String tax);

    @Query("SELECT o FROM Station o WHERE o.SKU=:sku")
    Optional<Station> findBySKU(String sku);

    @Query("SELECT o FROM Station o WHERE o.StationName LIKE %:name%")
    List<Station> findByStationNameContaining(String name);

    @Query("SELECT o FROM Station o WHERE o.StationName LIKE %:name%")
    Page<Station> findByStationNameContaining(String name, Pageable pageable);
}
