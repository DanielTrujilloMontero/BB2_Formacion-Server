package com.danieltrujillo.bb2.service.impl;

import com.danieltrujillo.bb2.dto.*;
import com.danieltrujillo.bb2.model.*;
import com.danieltrujillo.bb2.service.ModelMapperService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ModelMapperServiceImplementation implements ModelMapperService {

    @Override
    public List<ItemDTO> convertItemList2DTOList(List<Item> items) {
        return items.stream().map(this::convertItemElement2DTO).collect(Collectors.toList());
    }

    @Override
    public Set<PriceReductionDTO> convertPriceReductionSet2DTOSet(Set<PriceReduction> priceReductions) {
        return priceReductions.stream().map(this::convertPriceReduction2DTO).collect(Collectors.toSet());
    }

    @Override
    public Set<ItemSupplierDTO> convertItemSupplierSet2DTOSet(Set<ItemSupplier> itemSuppliers) {
        return itemSuppliers.stream().map(this::convertItemSupplier2DTO).collect(Collectors.toSet());
    }

    @Override
    public List<UserDTO> convertUserList2DTOList(List<User> users) {
        return users.stream().map(this::convertUser2DTO).collect(Collectors.toList());
    }

    @Override
    public List<DeactivationReasonDTO> convertDeactivationReasonList2DTOList(List<DeactivationReason> deactivationReasons) {
        return deactivationReasons.stream().map(this::convertDeactivationReason2DTO).collect(Collectors.toList());
    }

    @Override
    public ItemDTO convertItemElement2DTO(Item item) {
        if(item != null) {
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.addMappings(new PropertyMap<Item, ItemDTO>() {
                @Override
                protected void configure() {
                    skip().setPriceReductions(null);
                    skip().setSuppliers(null);
                }
            });
            return modelMapper.map(item, ItemDTO.class);
        }
        return null;
    }

    @Override
    public ItemDTO convertItem2DTO(Item item) {
        if(item != null) {
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.addMappings(new PropertyMap<Item, ItemDTO>() {
                @Override
                protected void configure() {
                }
            });
            return modelMapper.map(item, ItemDTO.class);
        }
        return null;
    }

    @Override
    public PriceReductionDTO convertPriceReduction2DTO(PriceReduction priceReduction) {
        if(priceReduction != null) {
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.addMappings(new PropertyMap<PriceReduction, PriceReductionDTO>() {
                @Override
                protected void configure() {
                    skip().setItem(null);
                }
            });
            return modelMapper.map(priceReduction, PriceReductionDTO.class);
        }
        return null;
    }

    @Override
    public ItemSupplierDTO convertItemSupplier2DTO(ItemSupplier itemSupplier) {
        if(itemSupplier != null) {
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.addMappings(new PropertyMap<ItemSupplier, ItemSupplierDTO>() {
                @Override
                protected void configure() {
                    skip().setItems(null);
                }
            });
            return modelMapper.map(itemSupplier, ItemSupplierDTO.class);
        }
        return null;
    }

    @Override
    public UserDTO convertUser2DTO(User user) {
        if(user != null) {
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.addMappings(new PropertyMap<User, UserDTO>() {
                @Override
                protected void configure() {
                    skip().setItems(null);
                }
            });
            return modelMapper.map(user, UserDTO.class);
        }
        return null;
    }

    @Override
    public DeactivationReasonDTO convertDeactivationReason2DTO(DeactivationReason deactivationReason) {
        if(deactivationReason != null) {
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.addMappings(new PropertyMap<DeactivationReason, DeactivationReasonDTO>() {
                @Override
                protected void configure() {
                }
            });
            return modelMapper.map(deactivationReason, DeactivationReasonDTO.class);
        }
        return null;
    }

    @Override
    public Item convertItemDTO2Entity(ItemDTO itemDTO) {
        ModelMapper modelMapper = new ModelMapper();
        if(itemDTO != null) {
            return modelMapper.map(itemDTO, Item.class);
        }
        return null;
    }

    @Override
    public User convertUserDTO2Entity(UserDTO userDTO) {
        ModelMapper modelMapper = new ModelMapper();
        if(userDTO != null) {
            return modelMapper.map(userDTO, User.class);
        }
        return null;
    }

    @Override
    public PriceReduction convertPriceReductionDTO2Entity(PriceReductionDTO priceReductionDTO) {
        ModelMapper modelMapper = new ModelMapper();
        if(priceReductionDTO != null) {
            return modelMapper.map(priceReductionDTO, PriceReduction.class);
        }
        return null;
    }

    @Override
    public ItemSupplier convertItemSupplierDTO2Entity(ItemSupplierDTO itemSupplierDTO) {
        ModelMapper modelMapper = new ModelMapper();
        if(itemSupplierDTO != null) {
            return modelMapper.map(itemSupplierDTO, ItemSupplier.class);
        }
        return null;
    }

    @Override
    public DeactivationReason convertDeactivationReasonDTO2Entity(DeactivationReasonDTO deactivationReasonDTO) {
        ModelMapper modelMapper = new ModelMapper();
        if(deactivationReasonDTO != null) {
            return modelMapper.map(deactivationReasonDTO, DeactivationReason.class);
        }
        return null;
    }
}
