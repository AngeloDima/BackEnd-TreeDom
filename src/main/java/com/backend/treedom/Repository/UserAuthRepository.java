package com.backend.treedom.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.treedom.Model.userAuth;

@Repository
public interface UserAuthRepository extends JpaRepository<userAuth, Integer> {
    userAuth findByName(String name);
}
