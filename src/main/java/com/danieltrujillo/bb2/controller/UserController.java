package com.danieltrujillo.bb2.controller;

import com.danieltrujillo.bb2.dto.UserDTO;
import com.danieltrujillo.bb2.service.UserService;
import com.danieltrujillo.bb2.service.ValueCheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ValueCheckerService valueCheckerService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/{name}")
    public UserDTO findUserByName(@PathVariable("name") String name) {
        return userService.findUserByName(name);
    }

}
