package com.example.MADProject.Bangalore.Tiamo;

import org.springframework.stereotype.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TiamoRepo extends JpaRepository<TiamoModel, Integer>{
    
}
