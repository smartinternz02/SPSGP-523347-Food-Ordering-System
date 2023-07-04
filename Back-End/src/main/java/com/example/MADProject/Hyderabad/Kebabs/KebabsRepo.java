package com.example.MADProject.Hyderabad.Kebabs;

import org.springframework.stereotype.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface KebabsRepo extends JpaRepository<KebabsModel, Integer>{
    
}
