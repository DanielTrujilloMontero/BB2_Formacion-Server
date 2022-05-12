package com.danieltrujillo.bb2.service.impl;

import com.danieltrujillo.bb2.dto.ItemDTO;
import com.danieltrujillo.bb2.dto.ItemSupplierDTO;
import com.danieltrujillo.bb2.dto.UserDTO;
import com.danieltrujillo.bb2.model.ItemSupplier;
import com.danieltrujillo.bb2.service.ItemService;
import com.danieltrujillo.bb2.service.ItemSupplierService;
import com.danieltrujillo.bb2.service.UserService;
import com.danieltrujillo.bb2.service.ValueCheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValueCheckerServiceImplementation implements ValueCheckerService {

    @Autowired
    ItemService itemService;

    @Autowired
    UserService userService;

    @Autowired
    ItemSupplierService itemSupplierService;

    @Override
    public ItemDTO checkItem(ItemDTO itemDTO) {
        return itemService.findItemByItemCode(itemDTO.getItemCode());
    }

    @Override
    public Boolean checkItems(List<ItemDTO> itemDTOS) {
        for (ItemDTO itemDTO: itemDTOS) {
            if(itemService.findItemByItemCode(itemDTO.getItemCode()) != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public UserDTO checkUser(UserDTO userDTO) {
        return userService.findUserByName(userDTO.getName());
    }

    @Override
    public ItemSupplierDTO checkItemSupplier(ItemSupplierDTO itemSupplierDTO) {
        return itemSupplierService.findItemSupplierByName(itemSupplierDTO.getName());
    }
}
