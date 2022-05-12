package com.danieltrujillo.bb2.service.impl;

import com.danieltrujillo.bb2.dto.ItemSupplierDTO;
import com.danieltrujillo.bb2.model.ItemSupplier;
import com.danieltrujillo.bb2.repository.ItemSupplierRepository;
import com.danieltrujillo.bb2.service.ItemSupplierService;
import com.danieltrujillo.bb2.service.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ItemSupplierServiceImplementation implements ItemSupplierService {
    @Autowired
    private ItemSupplierRepository itemSupplierRepository;

    @Autowired
    private ModelMapperService modelMapperService;


    public Set<ItemSupplierDTO> findAll() {
        Set<ItemSupplier> itemSuppliers = new HashSet<>(itemSupplierRepository.findAll());
        return modelMapperService.convertItemSupplierSet2DTOSet(itemSuppliers);
    }

    public void saveItemSupplier(ItemSupplierDTO itemSupplierDTO) {
        ItemSupplier itemSupplier = modelMapperService.convertItemSupplierDTO2Entity(itemSupplierDTO);
        itemSupplierRepository.save(itemSupplier);
    }

    @Override
    public void asociateItemSupplier(Long itemSupplierId, Long itemId) {
        itemSupplierRepository.asociateItemSupplier(itemSupplierId, itemId);
    }

    @Override
    public ItemSupplierDTO findItemSupplierByName(String name) {
        ItemSupplier itemSupplier =  itemSupplierRepository.findItemSupplierByName(name);
        return modelMapperService.convertItemSupplier2DTO(itemSupplier);
    }

}
