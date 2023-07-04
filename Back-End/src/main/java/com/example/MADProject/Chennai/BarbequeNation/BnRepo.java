package com.example.MADProject.Chennai.BarbequeNation;

import org.springframework.stereotype.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BnRepo extends JpaRepository<BnModel, Integer>{
    
}
