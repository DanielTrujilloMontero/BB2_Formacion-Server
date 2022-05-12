package com.danieltrujillo.bb2.service.impl;

import com.danieltrujillo.bb2.dto.PriceReductionDTO;
import com.danieltrujillo.bb2.model.PriceReduction;
import com.danieltrujillo.bb2.repository.PriceReductionRepository;
import com.danieltrujillo.bb2.service.ModelMapperService;
import com.danieltrujillo.bb2.service.PriceReductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PriceReductionServiceImplementation implements PriceReductionService {
    @Autowired
    private PriceReductionRepository priceReductionRepository;

    @Autowired
    private ModelMapperService modelMapperService;

    public Set<PriceReductionDTO> findAll() {
        Set<PriceReduction> priceReductions = new HashSet<>(priceReductionRepository.findAll());
        return modelMapperService.convertPriceReductionSet2DTOSet(priceReductions);
    }

    public void savePriceReduction(PriceReductionDTO priceReductionDTO) {
        PriceReduction priceReduction = modelMapperService.convertPriceReductionDTO2Entity(priceReductionDTO);
        priceReductionRepository.save(priceReduction);
    }
}
