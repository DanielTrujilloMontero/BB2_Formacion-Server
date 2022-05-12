package com.danieltrujillo.bb2.service;

import com.danieltrujillo.bb2.dto.*;
import com.danieltrujillo.bb2.model.*;

import java.util.List;
import java.util.Set;

public interface ModelMapperService {

    public List<ItemDTO> convertItemList2DTOList(List<Item> items);

    public Set<PriceReductionDTO> convertPriceReductionSet2DTOSet(Set<PriceReduction> priceReductions);

    public Set<ItemSupplierDTO> convertItemSupplierSet2DTOSet(Set<ItemSupplier> itemSuppliers);

    public List<UserDTO> convertUserList2DTOList(List<User> users);

    public List<DeactivationReasonDTO> convertDeactivationReasonList2DTOList(List<DeactivationReason> deactivationReasons);

    public ItemDTO convertItemElement2DTO(Item item);

    public ItemDTO convertItem2DTO(Item item);

    public PriceReductionDTO convertPriceReduction2DTO(PriceReduction priceReduction);

    public ItemSupplierDTO convertItemSupplier2DTO(ItemSupplier itemSupplier);

    public UserDTO convertUser2DTO(User user);

    public DeactivationReasonDTO convertDeactivationReason2DTO(DeactivationReason deactivationReason);

    public Item convertItemDTO2Entity(ItemDTO itemDTO);

    public User convertUserDTO2Entity(UserDTO userDTO);

    public PriceReduction convertPriceReductionDTO2Entity(PriceReductionDTO priceReductionDTO);

    public ItemSupplier convertItemSupplierDTO2Entity(ItemSupplierDTO itemSupplierDTO);

    public DeactivationReason convertDeactivationReasonDTO2Entity(DeactivationReasonDTO deactivationReasonDTO);
}
