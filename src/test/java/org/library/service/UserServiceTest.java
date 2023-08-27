package org.library.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.library.creator.UserCreator;
import org.library.rest.dto.UserDTO;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @MockBean
    UserService userService;

    @Test
    public void saveUserTests(){
        UserDTO userDTO = UserCreator.createUser();
        userService.register(userDTO);
        when(userService.findById(userDTO.getId())).thenReturn(userDTO);
        UserDTO found = userService.findById(userDTO.getId());

        assertThat(found).isNotNull();
        assertThat(found.getEmail()).isEqualTo(userDTO.getEmail());
        assertThat(found.getPassword()).isEqualTo(userDTO.getPassword());
        assertThat(found.getAddress()).isEqualTo(userDTO.getAddress());
        assertThat(found.getCountry()).isEqualTo(userDTO.getCountry());
        assertThat(found.getFirstName()).isEqualTo(userDTO.getFirstName());
        assertThat(found.getLastName()).isEqualTo(userDTO.getLastName());


    }

    @Test
    public void whenFindByIdThenReturnUser() {
        when(userService.findById(UUID.fromString("a57bdf71-d31e-4408-952e-8ee47803642c"))).thenReturn(UserCreator.createUser());
        UserDTO found = userService.findById(UUID.fromString("a57bdf71-d31e-4408-952e-8ee47803642c"));

        assertThat(found).isNotNull();
        assertThat(found.getEmail()).isEqualTo(UserCreator.EMAIL);
        assertThat(found.getPassword()).isEqualTo(UserCreator.PASSWORD);
        assertThat(found.getAddress()).isEqualTo(UserCreator.ADDRESS);
        assertThat(found.getCountry()).isEqualTo(UserCreator.COUNTRY);
        assertThat(found.getFirstName()).isEqualTo(UserCreator.FIRST_NAME);
        assertThat(found.getLastName()).isEqualTo(UserCreator.LAST_NAME);
    }


    @Test
    public void whenFindByUsernameThenReturnUser() {
        initMocks(this);

        when(userService.findByEmail(UserCreator.EMAIL)).thenReturn(UserCreator.createUser());
        UserDTO found = userService.findByEmail(UserCreator.EMAIL);

        assertThat(found).isNotNull();
        assertThat(found.getEmail()).isEqualTo(UserCreator.EMAIL);
        assertThat(found.getPassword()).isEqualTo(UserCreator.PASSWORD);
        assertThat(found.getAddress()).isEqualTo(UserCreator.ADDRESS);
        assertThat(found.getCountry()).isEqualTo(UserCreator.COUNTRY);
        assertThat(found.getFirstName()).isEqualTo(UserCreator.FIRST_NAME);
        assertThat(found.getLastName()).isEqualTo(UserCreator.LAST_NAME);
    }

    @Test
    public void whenFindByIdAndNoUserThenReturnNull(){
        UserDTO found = userService.findById(UUID.fromString("a57bdf71-d31e-4408-952e-8ee47803642c"));
        assertThat(found).isNull();
    }


    @Test
    public void whenFindByUsernameAndNoUserThenReturnNull(){
        UserDTO found = userService.findByEmail("Tests");

        assertThat(found).isNull();
    }


    @Test
    public void whenFindByEmailAndNoUserThenReturnNull(){
        UserDTO found = userService.findByEmail("example@donut.org");
        assertThat(found).isNull();
    }



}
