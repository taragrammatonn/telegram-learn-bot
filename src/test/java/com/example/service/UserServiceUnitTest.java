package com.example.service;

import com.example.dao.UserDAO;
import com.example.dao.model.User;
import com.example.factory.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceUnitTest {

    @Mock
    private UserDAO userDAO;

    private TelegramUserService telegramUserService;


    @BeforeEach
    void setUp() {
        telegramUserService = new TelegramUserServiceImpl(userDAO);
    }

    @Test
    void shouldReturnById() {
        User user = UserFactory.aUserWithId();

        when(userDAO.findById(any())).thenReturn(Optional.of(user));

        Optional<User> userById = telegramUserService.findById(user.getId());

        assertSoftly(softAssertions -> {
           softAssertions.assertThat(userById).isPresent();
           softAssertions. assertThat(user).usingRecursiveAssertion().isEqualTo(userById.get());
        });
    }

}