package com.example.MADProject.Pondicherry.JDOlive;

import org.springframework.stereotype.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface JDOliveRepo extends JpaRepository<JDOliveModel, Integer>{
    
}
