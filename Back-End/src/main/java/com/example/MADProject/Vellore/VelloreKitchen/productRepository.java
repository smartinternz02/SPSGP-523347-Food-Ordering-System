package com.example.MADProject.Vellore.VelloreKitchen;

import org.springframework.stereotype.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface productRepository extends JpaRepository<productItemModel, Integer>{
    
}
