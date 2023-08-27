package org.library.rest.request;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class AuthRequest {

    private String username;
    @ToString.Exclude
    private String password;
}
