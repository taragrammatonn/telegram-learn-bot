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
        userDAO.findById(id);
    }

    @Override
    public User save(Long id, User user) {
        return userDAO.save(id, user);
    }

    @Override
    public boolean deleteById(Long userId) {
        userDAO.deleteById(userId);
        return true;
    }
}
