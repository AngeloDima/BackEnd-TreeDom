package com.backend.treedom.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.treedom.Model.fotoModel;
import com.backend.treedom.Model.userAuth;
import com.backend.treedom.service.FotoService;
import com.backend.treedom.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FotoController {

    @Autowired
    private FotoService fotoService;

    @Autowired
    private UserService userService;

    @PostMapping("/uploadImage")
    public ResponseEntity<String> uploadImage(@RequestParam String username, @RequestBody fotoModel foto) {
        userAuth user = userService.findUserByName(username);
        if (user != null) {
            foto.setUser(user);
            fotoService.saveImage(foto);
            return ResponseEntity.ok("Immagine salvata con successo");
        } else {
            return ResponseEntity.status(404).body("Utente non trovato");
        }
    }
}