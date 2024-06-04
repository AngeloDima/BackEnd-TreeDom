package com.backend.treedom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.treedom.Model.userAuth;
import com.backend.treedom.Repository.UserAuthRepository;

@Service
public class UserService {

    @Autowired
    private UserAuthRepository userRepository;

    // salvo l'user nella sua Repository (Contenitore)
    public void saveUser(userAuth user) {
        userRepository.save(user);
    }

    // funzione molto basilare di autenticazione dell'utente ( controlla che name e
    // password della RequestBody e li confronta nel DB per trovare una
    // corrispondenza)
    public userAuth authenticateUser(String name, String password) {
        userAuth user = userRepository.findByName(name);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    // Cerca un utente per nome
    public userAuth findUserByName(String name) {
        return userRepository.findByName(name);
    }

    // Cerca un utente per id
    public userAuth getUserById(int userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
