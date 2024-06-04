package com.backend.treedom.Controller;

import java.util.List;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.backend.treedom.Model.fotoModel;
import com.backend.treedom.service.FotoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FotoController {

    @Autowired
    private FotoService fotoService;

    @PostMapping("/uploadImage")
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) {
        try {

            if (file.isEmpty()) {
                return new ResponseEntity<>("Il file è vuoto", HttpStatus.BAD_REQUEST);
            }

            fotoModel foto = fotoService.saveImage(file);

            return new ResponseEntity<>(foto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Errore durante il caricamento dell'immagine: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/images")
    public ResponseEntity<List<String>> getImages() {
        try {
            List<String> images = fotoService.getAllImagesDataAsBase64();
            return new ResponseEntity<>(images, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
