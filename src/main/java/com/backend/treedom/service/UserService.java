package com.backend.treedom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.treedom.Model.userAuth;
import com.backend.treedom.Repository.UserAuthRepository;

@Service
public class UserService {

    @Autowired
    private UserAuthRepository userRepository;

    public void saveUser(userAuth user) {
        userRepository.save(user);
    }

    public userAuth authenticateUser(String name, String password) {
        userAuth user = userRepository.findByName(name);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public userAuth findUserByName(String name) {
        return userRepository.findByName(name);
    }
}
