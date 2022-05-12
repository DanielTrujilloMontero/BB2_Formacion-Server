package com.danieltrujillo.bb2.service.impl;

import com.danieltrujillo.bb2.dto.ItemDTO;
import com.danieltrujillo.bb2.dto.ItemSupplierDTO;
import com.danieltrujillo.bb2.dto.PriceReductionDTO;
import com.danieltrujillo.bb2.dto.UserDTO;
import com.danieltrujillo.bb2.enums.ItemStateEnum;
import com.danieltrujillo.bb2.model.Item;
import com.danieltrujillo.bb2.model.ItemSupplier;
import com.danieltrujillo.bb2.model.PriceReduction;
import com.danieltrujillo.bb2.repository.ItemRepository;
import com.danieltrujillo.bb2.service.ItemService;
import com.danieltrujillo.bb2.service.ModelMapperService;
import com.danieltrujillo.bb2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class ItemServiceImplementation implements ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapperService modelMapperService;

    public List<ItemDTO> findAll() {
        List<Item> items = itemRepository.findAll();
        return modelMapperService.convertItemList2DTOList(items);
    }

    public List<ItemDTO> findItemsByState(ItemStateEnum state) {
        List<Item> items = itemRepository.findItemsByState(state);
        return modelMapperService.convertItemList2DTOList(items);
    }

    public ItemDTO findItemByItemCode(Long itemCode) {
        Item item = itemRepository.findItemByItemCode(itemCode);
        ItemDTO itemDTO = modelMapperService.convertItem2DTO(item);

        Set<PriceReduction> priceReductions = item.getPriceReductions();
        Set<PriceReductionDTO> priceReductionDTOS = modelMapperService.convertPriceReductionSet2DTOSet(priceReductions);
        itemDTO.setPriceReductions(priceReductionDTOS);

        Set<ItemSupplier> itemSuppliers = item.getSuppliers();
        Set<ItemSupplierDTO> itemSupplierDTOS = modelMapperService.convertItemSupplierSet2DTOSet(itemSuppliers);
        itemDTO.setSuppliers(itemSupplierDTOS);

        return itemDTO;
    }

    public void saveItem(ItemDTO itemDTO) {
        itemDTO.setCreationDate(new Date());

        UserDTO creator = userService.findUserByName(itemDTO.getCreator().getName());

        itemDTO.setCreator(creator);

        if(itemDTO.getState() == null) {
            itemDTO.setState(ItemStateEnum.ACTIVE);
        }

        Item item = modelMapperService.convertItemDTO2Entity(itemDTO);
        itemRepository.save(item);
    }

    public void updateItem(ItemDTO itemDTO) {
        Long itemId = itemRepository.findItemByItemCode(itemDTO.getItemCode()).getId();
        Item itemToUpdate = itemRepository.getOne(itemId);

        itemToUpdate.setDescription(itemDTO.getDescription());
        itemToUpdate.setPrice(itemDTO.getPrice());
        if(itemDTO.getState() == ItemStateEnum.ACTIVE || itemDTO.getState() == ItemStateEnum.DISCONTINUED) {
            itemToUpdate.setState(itemDTO.getState());
        }
        itemToUpdate.setState(itemDTO.getState());

        itemRepository.save(itemToUpdate);
    }

}
