package com.danieltrujillo.bb2.controller;

import com.danieltrujillo.bb2.dto.ItemDTO;
import com.danieltrujillo.bb2.dto.ItemSupplierDTO;
import com.danieltrujillo.bb2.dto.PriceReductionDTO;
import com.danieltrujillo.bb2.dto.UserDTO;
import com.danieltrujillo.bb2.enums.ItemStateEnum;
import com.danieltrujillo.bb2.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;

    @Autowired
    private PriceReductionService priceReductionService;

    @Autowired
    private ItemSupplierService itemSupplierService;

    @Autowired
    private ValueCheckerService valueCheckerService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/Items")
    public List<ItemDTO> findItems() {
        return itemService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/State/{state}")
    public List<ItemDTO> findItemsByState(@PathVariable("state") ItemStateEnum state) {
        return itemService.findItemsByState(state);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/Code/{itemCode}")
    public ItemDTO findItemByItemCode(@PathVariable("itemCode") Long itemCode) {
        return itemService.findItemByItemCode(itemCode);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/Add")
    public void saveItem(@RequestBody ItemDTO itemDTO) {
        if (valueCheckerService.checkItem(itemDTO) == null) {
            saveCreator(itemDTO);
            itemService.saveItem(itemDTO);
            ItemDTO insertedItem = itemService.findItemByItemCode(itemDTO.getItemCode());
            savePriceReductions(insertedItem);
            saveItemSuppliers(insertedItem);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/Modify")
    public void updateItem(@RequestBody ItemDTO itemDTO) {
        if(valueCheckerService.checkItem(itemDTO) != null) {
            itemService.updateItem(itemDTO);
        }
    }

    private void saveCreator(ItemDTO itemDTO) {
        if (itemDTO.getCreator() != null && valueCheckerService.checkUser(itemDTO.getCreator()) != null) {
            UserDTO creator = itemDTO.getCreator();
            userService.saveUser(creator);
        }
    }

    private void savePriceReductions(ItemDTO itemDTO) {
        if(itemDTO.getPriceReductions() != null && !itemDTO.getPriceReductions().isEmpty()) {
            for (PriceReductionDTO priceReductionDTO: itemDTO.getPriceReductions()) {
                priceReductionDTO.setItem(itemDTO);
                priceReductionService.savePriceReduction(priceReductionDTO);
            }
        }
    }

    private void saveItemSuppliers(ItemDTO itemDTO) {
        List<ItemDTO> itemDTOS = new ArrayList<ItemDTO>();
        itemDTOS.add(itemDTO);

        if(itemDTO.getSuppliers() != null && !itemDTO.getSuppliers().isEmpty()) {
            for (ItemSupplierDTO itemSupplierDTO : itemDTO.getSuppliers()) {
                itemSupplierDTO.setItems(itemDTOS);
                itemSupplierService.saveItemSupplier(itemSupplierDTO);
            }
        }
    }

}
