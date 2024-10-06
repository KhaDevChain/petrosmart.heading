package com.factory.heading.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.factory.heading.models.Chain;
import com.factory.heading.repository.ChainRepo;
import com.factory.heading.service.ChainService;

@Service
public class ChainServiceImpl implements ChainService {
    @Autowired
    private ChainRepo chainRepo;

    @Override
    public Chain findById(String chainId) {
        return chainRepo.findById(chainId).orElse(null);
    }

    @Override
    public Chain findBySKU(String sku) {
        return chainRepo.findBySKU(sku);
    }

    @Override
    public List<Chain> findChains() {
        return chainRepo.findAll();
    }

    @Override
    public List<Chain> findByChainNameLike(String character) {
        return chainRepo.findByChainNameLike(character);
    }

    @Override
    public Page<Chain> findChains(Pageable pageable) {
        return chainRepo.findAll(pageable);
    }

    @Override
    public Page<Chain> findChains(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return chainRepo.findAll(pageable);
    }

}
