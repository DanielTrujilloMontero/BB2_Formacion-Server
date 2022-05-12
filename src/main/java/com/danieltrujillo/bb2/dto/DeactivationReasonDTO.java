package com.danieltrujillo.bb2.dto;

import com.danieltrujillo.bb2.model.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DeactivationReasonDTO {
    private Long id;
    private String description;
    private Date creationDate;
    private ItemDTO item;
}
