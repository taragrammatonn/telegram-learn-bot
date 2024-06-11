package com.example.controller;

import com.example.dao.model.User;
import com.example.service.TelegramUserService;
import com.example.service.TelegramUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController("/api")
public class UserController {

    private final TelegramUserService telegramUserService;

    @Autowired
    public UserController(TelegramUserServiceImpl telegramUserService) {
        this.telegramUserService = telegramUserService;
    }

    @GetMapping("/user/{userId}")
    public Optional<User> user(@RequestParam String userId) {
        return Optional.of(telegramUserService.findById(Long.valueOf(userId)));
    }

}
