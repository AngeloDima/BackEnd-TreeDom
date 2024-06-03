package com.backend.treedom.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.treedom.Model.fotoModel;

@Repository
public interface FotoRepository extends JpaRepository<fotoModel, Integer> {
}
