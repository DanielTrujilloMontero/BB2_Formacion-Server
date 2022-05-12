package com.danieltrujillo.bb2.service;

import com.danieltrujillo.bb2.dto.ItemDTO;
import com.danieltrujillo.bb2.enums.ItemStateEnum;

import java.util.List;

public interface ItemService {
    public List<ItemDTO> findAll();

    public List<ItemDTO> findItemsByState(ItemStateEnum state);

    public ItemDTO findItemByItemCode(Long itemCode);

    public void saveItem(ItemDTO itemDTO);

    public void updateItem(ItemDTO itemDTO);
}
