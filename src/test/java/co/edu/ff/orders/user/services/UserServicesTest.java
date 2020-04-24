package co.edu.ff.orders.user.services;

import co.edu.ff.orders.user.domain.Password;
import co.edu.ff.orders.user.domain.UserCreated;
import co.edu.ff.orders.user.domain.UserOperation;
import co.edu.ff.orders.user.domain.Username;
import co.edu.ff.orders.user.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServicesTest {

    @Autowired
    UserServices userServices;

    @MockBean
    UserRepository repository;

    @Test
    void createUser() {
        // arrange
        Username userNameMock = ArgumentMatchers.any(Username.class);
        Username username = Username.of("Username123");
        Password password = Password.of("Password1234");
        UserCreated userCreated = UserCreated.of(
                username,
                password,
                1L
        );
        when(repository.findByUsername(userNameMock))
                .thenReturn(Optional.of(userCreated));

        // act
        UserOperation user = this.userServices.createUser(username, password);

        // assert

        assertAll(
                () -> assertFalse(user.isValid(), "Un usuario creado no retorna error al intentar crearlo de nuevo"),
                () -> {

                }
        );

    }
}