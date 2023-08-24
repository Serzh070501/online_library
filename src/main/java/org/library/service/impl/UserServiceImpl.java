package org.library.service.impl;

import org.library.convertor.UserConverter;
import org.library.model.entity.User;
import org.library.repository.UserRepository;
import org.library.rest.dto.UserDTO;
import org.library.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Override
    public User register(UserDTO userDTO) {
        return null;
    }

    @Override
    public User update(String email, UserDTO userDTO) {
        final User user = userRepository.findByEmail(email);
        return null;
    }

    @Override
    public User findById(UUID id) {
        return null;
    }

//    @Override
//    public User findById(UUID id) {
//        final User user = userRepository.findById(id);
//        return user;
//    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public List<UserDTO> getAll() {
        return null;
    }

    @Override
    public void delete(String email) {

    }
}
