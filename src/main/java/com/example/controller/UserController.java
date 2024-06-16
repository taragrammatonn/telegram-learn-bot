package com.example.controller;

import com.example.dao.model.User;
import com.example.service.TelegramUserService;
import com.example.service.TelegramUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/user/{userId}")
    public Optional<User> save(@PathVariable String userId, @RequestBody User user) {
        return Optional.of(telegramUserService.save(Long.valueOf(userId), user));
    }

    @PostMapping("/user/{userId}")
    public boolean deleteById(@PathVariable String userId) {
        telegramUserService.deleteById(Long.valueOf(userId));
        return true;
    }
}
