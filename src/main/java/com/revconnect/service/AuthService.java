package com.revconnect.service;

import com.revconnect.dao.UserDAO;

public class AuthService {

    private UserDAO userDAO = new UserDAO();

    // Register
    public void register(String email, String password, String name,
                         String bio, String userType, String location) throws Exception {

        userDAO.registerUser(email, password, name, bio, userType, location);
    }

    // Login validation
    public int login(String email, String password) throws Exception {
        return userDAO.validateLogin(email, password);
    }
}
