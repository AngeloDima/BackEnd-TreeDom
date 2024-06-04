package com.backend.treedom.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.backend.treedom.Model.fotoModel;
import com.backend.treedom.Repository.FotoRepository;

@Service
public class FotoService {

    @Autowired
    private FotoRepository fotoRepository;

    public fotoModel saveImage(MultipartFile file, String description) throws Exception {
        try {
            byte[] imageData = file.getBytes();

            fotoModel foto = new fotoModel();
            foto.setImagePath(imageData);
            foto.setDescription(description);

            return fotoRepository.save(foto);
        } catch (Exception e) {
            throw new Exception("Impossibile salvare l'immagine: " + e.getMessage());
        }
    }

    public List<String> getAllImagesDataAsBase64() {
        List<fotoModel> images = fotoRepository.findAll();
        List<String> imageDataList = new ArrayList<>();
        for (fotoModel image : images) {
            String imageDataAsBase64 = Base64.getEncoder().encodeToString(image.getImagePath());
            imageDataList.add(imageDataAsBase64);
        }
        return imageDataList;
    }

}
