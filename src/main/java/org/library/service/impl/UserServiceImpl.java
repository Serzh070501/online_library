package org.library.service.impl;

import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDTO register(UserDTO userDTO) {
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User entity = userConverter.convertToEntity(userDTO);
        entity.setRole(Role.USER);
        return userConverter.convertToDTO(userRepository.save(entity));
    }

    @Override
    public UserDTO registerAdmin(UserDTO userDTO) {
        logger.info("Registering admin with dto - {}", userDTO);
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User entity = userConverter.convertToEntity(userDTO);
        entity.setRole(Role.ADMIN);
        logger.info("Successfully registered admin with dto - {}", userDTO);
        return userConverter.convertToDTO(userRepository.save(entity));
    }

    @Override
    public UserDTO update(String email, UserDTO userDTO) {
        return userConverter.convertToDTO(userRepository.findByEmail(email));

    }

    @Override
    public UserDTO findById(UUID id) {
        logger.info("Finding user with id - {}", id.toString());
         User user = this.userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Not found user by this id%d", id)));

        UserDTO userDTO = userConverter.convertToDTO(user);
        logger.info("Successfully found user with id - {}, result - {}", id.toString(), userDTO);
        return userDTO;
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
