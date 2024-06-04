package com.backend.treedom.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.treedom.Model.userAuth;
import com.backend.treedom.service.UserService;

//CROSSORIGIN per fare richieste anche da oltri URL (come il frontEnd)
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AuthController {

    // Richiamo il service per gli user
    @Autowired
    private UserService userService;

    // creo un endPoint per la registrazione degli utenti
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody userAuth user) {
        userService.saveUser(user);
        return ResponseEntity.ok("Registrazione avvenuta con successo");
    }

    // creo un endPoint per il Login degli utenti
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody userAuth user) {
        userAuth authenticatedUser = userService.authenticateUser(user.getName(), user.getPassword());
        if (authenticatedUser != null) {
            return ResponseEntity.ok(authenticatedUser);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Credenziali non valide");
            return ResponseEntity.status(401).body(response);
        }
    }

}
