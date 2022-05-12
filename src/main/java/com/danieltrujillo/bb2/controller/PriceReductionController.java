package com.danieltrujillo.bb2.controller;

import com.danieltrujillo.bb2.dto.ItemDTO;
import com.danieltrujillo.bb2.dto.PriceReductionDTO;
import com.danieltrujillo.bb2.service.ItemService;
import com.danieltrujillo.bb2.service.PriceReductionService;
import com.danieltrujillo.bb2.service.ValueCheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/PriceReduction")
public class PriceReductionController {
    @Autowired
    private PriceReductionService priceReductionService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private ValueCheckerService valueCheckerService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/PriceReductions")
    public Set<PriceReductionDTO> findPriceReductions() {
        return priceReductionService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/Add")
    public void savePriceReduction(PriceReductionDTO priceReductionDTO) {
        if (priceReductionDTO.getItem() != null) {
            ItemDTO itemInserted = valueCheckerService.checkItem(priceReductionDTO.getItem());
            priceReductionDTO.setItem(itemInserted);
            priceReductionService.savePriceReduction(priceReductionDTO);
        }
    }

}
