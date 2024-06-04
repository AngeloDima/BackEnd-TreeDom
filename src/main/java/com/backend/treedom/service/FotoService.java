package com.backend.treedom.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Base64;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.backend.treedom.Model.fotoModel;
import com.backend.treedom.Repository.FotoRepository;

@Service
public class FotoService {

    @Autowired
    private FotoRepository fotoRepository;

    public fotoModel saveImage(MultipartFile file, String description, int userId) throws Exception {
        try {
            byte[] imageData = file.getBytes();

            fotoModel foto = new fotoModel();
            foto.setImagePath(imageData);
            foto.setDescription(description);
            foto.setUserId(userId);
            return fotoRepository.save(foto);
        } catch (Exception e) {
            throw new Exception("Impossibile salvare l'immagine: " + e.getMessage());
        }
    }

    public List<Map<String, String>> getAllImagesDataAsBase64ByUserId(int userId) {
        List<fotoModel> images = fotoRepository.findByUserId(userId);
        List<Map<String, String>> imageDataList = new ArrayList<>();
        for (fotoModel image : images) {
            Map<String, String> imageData = new HashMap<>();
            imageData.put("id", String.valueOf(image.getId()));
            imageData.put("data", Base64.getEncoder().encodeToString(image.getImagePath()));
            imageData.put("description", image.getDescription());

            imageDataList.add(imageData);
        }
        return imageDataList;
    }

}
