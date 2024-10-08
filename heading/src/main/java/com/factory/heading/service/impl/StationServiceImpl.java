package com.factory.heading.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.factory.heading.models.Station;
import com.factory.heading.repository.StationRepo;
import com.factory.heading.service.StationService;

@Service
public class StationServiceImpl implements StationService {
    @Autowired
    private StationRepo stationRepo;

    @Override
    public Station findByTax(String tax) {
        return stationRepo.findByTax(tax).orElse(null);
    }

    @Override
    public Station findBySKU(String sku) {
        return stationRepo.findBySKU(sku).orElse(null);
    }

    @Override
    public List<Station> findByStationNameLike(String name) {
        return stationRepo.findByStationNameContaining(name);
    }

    @Override
    public Page<Station> findPageByStationNameLike(String name, Pageable pageable) {
        return stationRepo.findByStationNameContaining(name, pageable);
    }

    @Override
    public Page<Station> findPageByStationNameLike(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return stationRepo.findByStationNameContaining(name, pageable);
    }
    
}
