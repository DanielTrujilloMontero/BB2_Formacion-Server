package com.danieltrujillo.bb2.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PriceReductionDTO {
    private Long id;
    private int reducedPrice;
    private Date startDate;
    private Date endDaTE;
    private ItemDTO item;

}
