package org.library.rest.controller;


import lombok.extern.slf4j.Slf4j;
import org.library.rest.dto.UserDTO;
import org.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userdto) {
        log.info("aaaaa");
        return ResponseEntity.ok((userService.registerAdmin(userdto)));
    }



}
