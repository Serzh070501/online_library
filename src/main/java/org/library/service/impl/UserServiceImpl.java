package org.library.service.impl;

import org.library.convertor.UserConverter;
import org.library.model.entity.User;
import org.library.model.enums.Role;
import org.library.repository.UserRepository;
import org.library.rest.dto.UserDTO;
import org.library.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserConverter userConverter;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public UserDTO register(UserDTO userDTO) {
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return userConverter.convertToDTO(userRepository.save(userConverter.convertToEntity(userDTO)));
    }

    @Override
    public UserDTO update(String email, UserDTO userDTO) {
        return userConverter.convertToDTO(userRepository.findByEmail(email));

    }

    @Override
    public UserDTO findById(UUID id) {
         User user = this.userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Not found user by this id%d", id)));

        return  userConverter.convertToDTO(user);
    }

    @Override
    public UserDTO findByEmail(String email) {
        return userConverter.convertToDTO(userRepository.findByEmail(email));
    }

    @Override
    public List<UserDTO> getAll() {
        return userConverter.bulkConvert(userRepository.findAll());
    }

    @Override
    public void delete(String email) {
        userRepository.deleteByEmail(email);
    }
}
