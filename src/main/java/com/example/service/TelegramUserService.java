package com.example.service;

import com.example.dao.model.User;

public interface TelegramUserService {

    User findById(Long id);

    User save(Long id, User user);

    boolean deleteById(Long userId);
}
