package com.example.service;

import com.example.dao.UserDAO;
import com.example.factory.UserFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@IntegrationTest(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
class UserServiceTest {

    @Autowired
    private TelegramUserService telegramUserService;

    @MockBean
    private UserDAO userDAO;

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mvc;

    @BeforeEach
    public void setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext)
                .build();
    }

    @Test
    void shouldReturnUserById() throws Exception {

        var testUser = UserFactory.aUserWithId();

        var objectMapper = new ObjectMapper();
        var userJson = objectMapper.writeValueAsString(testUser);

        when(userDAO.findById(testUser.getId())).thenReturn(Optional.of(testUser));

        mvc.perform(get("/api/user/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(content().json(userJson, true));
    }
}
