package org.library.service;

import org.library.rest.dto.UserDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserDTO register(UserDTO userDTO);

    UserDTO registerAdmin(UserDTO userDTO);

    UserDTO update(String email, UserDTO userDTO);

    UserDTO findById(UUID id);

    UserDTO findByEmail(String email);

    List<UserDTO> getAll();

    void delete (String email);
}
