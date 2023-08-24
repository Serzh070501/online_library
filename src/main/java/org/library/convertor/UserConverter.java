package org.library.convertor;


import org.library.model.entity.User;
import org.library.rest.dto.UserDTO;

import java.util.List;

public interface UserConverter {

    User convertToEntity(UserDTO userDTO);

    UserDTO convertToDTO(User user);

    List<UserDTO> bulkConvert(List<User> users);
}
