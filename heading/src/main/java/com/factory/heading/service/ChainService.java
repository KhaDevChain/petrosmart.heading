package com.factory.heading.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.factory.heading.models.Chain;

public interface ChainService {
    Chain findById(String chainId);
    Chain findBySKU(String sku);

    List<Chain> findChains();
    List<Chain> findByChainNameLike(String character);


    Page<Chain> findChains(Pageable pageable);
    Page<Chain> findChains(int page, int size);
}
