package com.example.service;

import com.example.dao.model.User;

import java.util.Optional;

public interface TelegramUserService {

    Optional<User> findById(Long id);

    User save(Long id, User user);

    boolean deleteById(Long userId);
}
