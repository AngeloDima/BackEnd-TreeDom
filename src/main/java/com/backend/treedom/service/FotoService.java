package com.backend.treedom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.backend.treedom.Model.fotoModel;
import com.backend.treedom.Repository.FotoRepository;

@Service
public class FotoService {

    @Autowired
    private FotoRepository fotoRepository;

    public fotoModel saveImage(MultipartFile file) throws Exception {
        try {
            byte[] imageData = file.getBytes();
            fotoModel foto = new fotoModel();
            foto.setImagePath(imageData);
            return fotoRepository.save(foto);
        } catch (Exception e) {
            throw new Exception("Impossibile salvare l'immagine: " + e.getMessage());
        }
    }

}
