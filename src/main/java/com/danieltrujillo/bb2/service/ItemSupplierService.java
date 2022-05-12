package com.danieltrujillo.bb2.service;

import com.danieltrujillo.bb2.dto.ItemSupplierDTO;

import java.util.Set;

public interface ItemSupplierService {

    public Set<ItemSupplierDTO> findAll();

    public void saveItemSupplier(ItemSupplierDTO itemSupplierDTO);

    public void asociateItemSupplier(Long itemSupplierId, Long itemId);

    public ItemSupplierDTO findItemSupplierByName(String name);

}
