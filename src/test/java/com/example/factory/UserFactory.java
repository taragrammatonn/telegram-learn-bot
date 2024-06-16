package com.example.factory;

import com.example.dao.model.User;

public class UserFactory {

    public static User aUser() {
        return new User("John", "Doe");
    }

    public static User aUserWithId() {
        return new User(1L, "John", "Doe");
    }

}
