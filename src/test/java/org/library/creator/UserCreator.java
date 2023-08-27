package org.library.creator;

import org.library.model.entity.User;
import org.library.rest.dto.UserDTO;

import java.util.UUID;

public class UserCreator {
    public static final String FIRST_NAME = "Jack";
    public static final String LAST_NAME = "Grealish";
    public static final String PHONE_NUMBER = "+999333444777";
    public static final String EMAIL = "jack.mancity@gmail.com";
    public static final String ADDRESS = "London";
    public static final String COUNTRY = "England";
    public static final int POSTAL_ZIP = 567;
    public static final String PASSWORD = "123jack";


    public static UserDTO createUser() {
        UserDTO testUser = new UserDTO();
        testUser.setFirstName(FIRST_NAME);
        testUser.setLastName(LAST_NAME);
        testUser.setPhoneNumber(PHONE_NUMBER);
        testUser.setEmail(EMAIL);
        testUser.setPassword(PASSWORD);
        testUser.setAddress(ADDRESS);
        testUser.setCountry(COUNTRY);
        testUser.setPostalZip(POSTAL_ZIP);

        return testUser;
    }
}
