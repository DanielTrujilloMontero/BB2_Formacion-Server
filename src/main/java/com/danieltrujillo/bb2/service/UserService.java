package com.danieltrujillo.bb2.service;

import com.danieltrujillo.bb2.dto.UserDTO;

public interface UserService {
    public UserDTO findUserByName(String name);

    public void saveUser(UserDTO userDTO);
}
