package com.backend.treedom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.treedom.Model.fotoModel;
import com.backend.treedom.Repository.FotoRepository;

@Service
public class FotoService {

    @Autowired
    private FotoRepository fotoRepository;

    public void saveImage(fotoModel foto) {
        fotoRepository.save(foto);
    }
}
