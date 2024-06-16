package com.example.service;

import com.example.dao.UserDAO;
import com.example.dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TelegramUserServiceImpl implements TelegramUserService {

    private final UserDAO userDAO;

    @Autowired
    public TelegramUserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userDAO.findById(id);
//        Business logic
        /*
        *
        *
        *
        *
        *
        * */
    }

    @Override
    public User save(Long id, User user) {
        var referenceById = userDAO.getReferenceById(user.getId());
        if (referenceById != null) {
            return user.updateUser(user, referenceById);
        }
        return userDAO.save(user);
    }

    @Override
    public boolean deleteById(Long userId) {
        try {
            userDAO.deleteById(userId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
