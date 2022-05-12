package com.danieltrujillo.bb2.dto;

import com.danieltrujillo.bb2.enums.ItemStateEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class ItemDTO {
    private Long id;
    private Long itemCode;
    private String description;
    private double price;
    private Set<ItemSupplierDTO> suppliers;
    private ItemStateEnum state;
    private Set<PriceReductionDTO> priceReductions;
    private Date creationDate;
    private UserDTO creator;

    public double applyPriceReduction() {
        Date today = new Date();
        for (PriceReductionDTO pr: priceReductions) {
            if(!today.before(pr.getStartDate()) && today.after(pr.getEndDaTE())) {
                return getNewPrice(pr.getReducedPrice());
            }
        }
        return price;
    }

    private double getNewPrice(int priceReduction) {
        return price - ((price / 100)*priceReduction);
    }

}
