package org.library.convertor.impl;

import org.library.convertor.UserConverter;
import org.library.model.entity.User;
import org.library.rest.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverterImpl implements UserConverter {

    private static final Logger logger = LoggerFactory.getLogger(UserConverterImpl.class);


    @Override
    public User convertToEntity(UserDTO userDTO) {
        logger.info("start convert to Entity");

        User user = new User();

         user.setId(userDTO.getId());
         user.setCountry(userDTO.getCountry());
         user.setAddress(userDTO.getAddress());
         user.setEmail(userDTO.getEmail());
         user.setPassword(userDTO.getPassword());
         user.setFirstName(userDTO.getFirstName());
         user.setLastName(userDTO.getLastName());
         user.setPhoneNumber(userDTO.getPhoneNumber());
         user.setPostalZip(userDTO.getPostalZip());
         user.setRole(userDTO.getRole());

         return user;
    }

    @Override
    public UserDTO convertToDTO(User user) {
        logger.info("start convert to DTO");

        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setCountry(user.getCountry());
        userDTO.setAddress(user.getAddress());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setPostalZip(user.getPostalZip());
        userDTO.setRole(user.getRole());

        return userDTO;
    }

    @Override
    public List<UserDTO> bulkConvert(List<User> users) {
        return users.stream().map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
