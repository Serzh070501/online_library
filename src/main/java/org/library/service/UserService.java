package org.library.service;

import org.library.model.entity.User;
import org.library.rest.dto.UserDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User register(UserDTO userDTO);

    User update(String email, UserDTO userDTO);

    User findById(UUID id);

    User findByEmail(String email);

    List<UserDTO> getAll();

    void delete (String email);
}
