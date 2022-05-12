package com.danieltrujillo.bb2.dto;

import com.danieltrujillo.bb2.enums.UserRoleEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String name;
    private String password;
    private UserRoleEnum userRol;
    private List<ItemDTO> items;
}
