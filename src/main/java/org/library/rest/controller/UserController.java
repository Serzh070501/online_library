package org.library.rest.controller;

import org.library.convertor.UserConverter;
import org.library.rest.dto.UserDTO;
import org.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserConverter userConverter;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userdto) {
        return ResponseEntity.ok((userService.register(userdto)));
    }

    @GetMapping("/search")
    public ResponseEntity<UserDTO> search(@RequestParam("email") String email){
        return ResponseEntity.ok(userService.findByEmail(email));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDTO>> geAllUsers(){
        return ResponseEntity.ok(userService.getAll());
    }

    @PutMapping("/{email}")
    public ResponseEntity<UserDTO> update(@PathVariable String email, @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.update(email, userDTO));
    }

    @DeleteMapping("/{email} ")
    public ResponseEntity<String> delete (@RequestBody String email){
        userService.delete(email);
        return ResponseEntity.ok("Book was deleted successfully");
    }

}
