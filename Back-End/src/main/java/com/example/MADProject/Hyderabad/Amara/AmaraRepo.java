package com.example.MADProject.Hyderabad.Amara;

import org.springframework.stereotype.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AmaraRepo extends JpaRepository<AmaraModel, Integer>{
    
}
