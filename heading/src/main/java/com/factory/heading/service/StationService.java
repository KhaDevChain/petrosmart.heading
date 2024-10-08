package com.factory.heading.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.factory.heading.models.Station;

public interface StationService {
    // OBJECT
    Station findByTax(String tax);
    Station findBySKU(String sku);

    // LIST
    List<Station> findByStationNameLike(String name);

    // PAGE
    Page<Station> findPageByStationNameLike(String name, Pageable pageable);
    Page<Station> findPageByStationNameLike(String name, int page, int size);
}
