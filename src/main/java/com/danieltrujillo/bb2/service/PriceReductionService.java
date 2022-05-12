package com.danieltrujillo.bb2.service;

import com.danieltrujillo.bb2.dto.PriceReductionDTO;

import java.util.Set;

public interface PriceReductionService {
    public Set<PriceReductionDTO> findAll();

    public void savePriceReduction(PriceReductionDTO priceReductionDTO);
}
