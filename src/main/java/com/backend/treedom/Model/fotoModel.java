package com.backend.treedom.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob; // Importa questa annotazione per l'utilizzo di @Lob

@Entity
public class fotoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Lob
    private byte[] imagePath;

    private List<String> identifiedElements;

    public List<String> getIdentifiedElements() {
        return identifiedElements;
    }

    public void setIdentifiedElements(List<String> identifiedElements) {
        this.identifiedElements = identifiedElements;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImagePath() {
        return imagePath;
    }

    public void setImagePath(byte[] imagePath) {
        this.imagePath = imagePath;
    }

}
