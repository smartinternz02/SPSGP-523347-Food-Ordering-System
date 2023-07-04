package com.example.MADProject.Bangalore.IndianDarbar;

import org.springframework.stereotype.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DarbarRepo extends JpaRepository<DarbarModel, Integer>{
    
}
