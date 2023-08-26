package org.library.rest.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
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

}
