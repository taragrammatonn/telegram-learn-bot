package com.example.controller;

import com.example.dao.model.User;
import com.example.service.TelegramUserService;
import com.example.service.TelegramUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController("/api")
public class UserController {

    private final TelegramUserService telegramUserService;

    @Autowired
    public UserController(TelegramUserServiceImpl telegramUserService) {
        this.telegramUserService = telegramUserService;
    }

    @GetMapping(value = "/user/{userId}", produces = APPLICATION_JSON_VALUE)
    public Optional<User> user(@RequestParam String userId) {
        return telegramUserService.findById(Long.valueOf(userId));
    }

    @PutMapping("/user/{userId}")
    public Optional<User> save(@PathVariable String userId, @RequestBody User user) {
        return Optional.of(telegramUserService.save(Long.valueOf(userId), user));
    }

    @PostMapping("/user/{userId}")
    public boolean deleteById(@PathVariable String userId) {
        return telegramUserService.deleteById(Long.valueOf(userId));
    }
}
