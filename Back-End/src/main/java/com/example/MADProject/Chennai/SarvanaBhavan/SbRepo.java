package com.example.MADProject.Chennai.SarvanaBhavan;

import org.springframework.stereotype.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SbRepo extends JpaRepository<SbModel, Integer>{
    
}
