package com.example.MADProject.Registration;

import org.springframework.stereotype.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SignUpRepo extends JpaRepository<SignUpModel, Integer>{
    
}
