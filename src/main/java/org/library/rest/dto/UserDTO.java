package org.library.rest.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.library.model.enums.Role;

import java.util.UUID;

@Data
public class UserDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private int postalZip;
    private String country;
    private String password;
    private String phoneNumber;

    private Role role;

}
