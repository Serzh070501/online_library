package org.library.convertor.impl;

import org.library.convertor.UserConverter;
import org.library.model.entity.User;
import org.library.rest.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverterImpl implements UserConverter {

    @Override
    public User convertToEntity(UserDTO userDTO) {
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



         return user;
    }

    @Override
    public UserDTO convertToDTO(User user) {
        return null;
    }

    @Override
    public List<UserDTO> bulkConvert(List<User> users) {
        return users.stream().map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}