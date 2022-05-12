package com.danieltrujillo.bb2.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ItemSupplierDTO {
    private Long id;
    private String name;
    private String country;
    private List<ItemDTO> items;

}
