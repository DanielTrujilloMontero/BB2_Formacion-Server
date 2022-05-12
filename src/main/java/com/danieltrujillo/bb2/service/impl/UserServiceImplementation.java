package com.danieltrujillo.bb2.service.impl;

import com.danieltrujillo.bb2.dto.UserDTO;
import com.danieltrujillo.bb2.model.User;
import com.danieltrujillo.bb2.repository.UserRepository;
import com.danieltrujillo.bb2.service.ModelMapperService;
import com.danieltrujillo.bb2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapperService modelMapperService;

    public UserDTO findUserByName(String name) {
        User user = userRepository.findUserByName(name);
        return modelMapperService.convertUser2DTO(user);
    }

    public void saveUser(UserDTO userDTO) {
        User user = modelMapperService.convertUserDTO2Entity(userDTO);
        userRepository.save(user);
    }
}
