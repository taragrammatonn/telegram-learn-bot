package com.example.service;

import com.example.dao.UserDAO;
import com.example.dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelegramUserServiceImpl implements TelegramUserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public boolean deleteById(Long userId) {
        userDAO.deleteById(userId);
        return true;
    }
}
