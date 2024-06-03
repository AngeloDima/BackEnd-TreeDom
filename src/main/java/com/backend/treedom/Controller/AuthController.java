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

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody userAuth user) {
        userService.saveUser(user);
        return ResponseEntity.ok("Registrazione avvenuta con successo");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody userAuth user) {
        userAuth authenticatedUser = userService.authenticateUser(user.getName(), user.getPassword());
        if (authenticatedUser != null) {
            // Returning authenticated user as JSON
            return ResponseEntity.ok(authenticatedUser);
        } else {
            // Returning error message as JSON
            Map<String, String> response = new HashMap<>();
            response.put("message", "Credenziali non valide");
            return ResponseEntity.status(401).body(response);
        }
    }

}
