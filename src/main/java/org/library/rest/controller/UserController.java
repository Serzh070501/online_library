package org.library.rest.controller;

import org.library.convertor.UserConverter;
import org.library.rest.dto.UserDTO;
import org.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserConverter userConverter;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userdto) {
        return ResponseEntity.ok(userConverter.convertToDTO(userService.register(userdto)));


    }

}
