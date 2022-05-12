package com.danieltrujillo.bb2.service;

import com.danieltrujillo.bb2.dto.ItemDTO;
import com.danieltrujillo.bb2.dto.ItemSupplierDTO;
import com.danieltrujillo.bb2.dto.UserDTO;

import java.util.List;

public interface ValueCheckerService {

    public ItemDTO checkItem(ItemDTO itemDTO);

    public Boolean checkItems(List<ItemDTO> itemDTOS);

    public UserDTO checkUser(UserDTO userDTO);

    public ItemSupplierDTO checkItemSupplier(ItemSupplierDTO itemSupplierDTO);




}
