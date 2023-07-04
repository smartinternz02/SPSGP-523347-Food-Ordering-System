package com.example.MADProject.Chennai.SarvanaBhavan;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("SbService")
public class SbService {

    @Autowired
    private SbRepo repository;


    @Transactional
    public List<SbModel> getAllProducts(){
        return repository.findAll();
    }

    @Transactional
    public SbModel getProductById(int id){
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public SbModel createProduct(SbModel product){
        return repository.save(product);
    }

    
    @Transactional
    public SbModel updateProduct(int id, SbModel product){
        SbModel productItem = repository.findById(id).orElse(null);

        productItem.setName(product.getName());
        productItem.setImgUrl(product.getImgUrl());
        productItem.setDescription(product.getDescription());
        productItem.setPrice(product.getPrice());
        productItem.setRestName(product.getRestName());
        productItem.setdTime(product.getdTime());

        return repository.save(productItem);

    }

    @Transactional    
    public void deleteProduct(int id){
        repository.deleteById(id);
    }

}
