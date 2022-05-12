package com.danieltrujillo.bb2.controller;

import com.danieltrujillo.bb2.dto.ItemDTO;
import com.danieltrujillo.bb2.dto.ItemSupplierDTO;
import com.danieltrujillo.bb2.service.ItemService;
import com.danieltrujillo.bb2.service.ItemSupplierService;
import com.danieltrujillo.bb2.service.ValueCheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/ItemSupplier")
public class ItemSupplierController {
    @Autowired
    private ItemSupplierService itemSupplierService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private ValueCheckerService valueCheckerService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/Suppliers")
    public Set<ItemSupplierDTO> findItemSuppliers() {
        return itemSupplierService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/Add")
    public void saveItemSupplier(ItemSupplierDTO itemSupplierDTO) {
        if(valueCheckerService.checkItemSupplier(itemSupplierDTO) == null) {
            itemSupplierService.saveItemSupplier(itemSupplierDTO);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/Asociate")
    public void asociateSupplier2Item(ItemSupplierDTO itemSupplierDTO) {
        if(itemSupplierDTO != null &&
                valueCheckerService.checkItemSupplier(itemSupplierDTO) != null &&
                valueCheckerService.checkItems(itemSupplierDTO.getItems())) {
            for (ItemDTO itemDTO: itemSupplierDTO.getItems()) {
                itemSupplierService.asociateItemSupplier(itemSupplierDTO.getId(), itemDTO.getId());
            }
        }
    }

}
