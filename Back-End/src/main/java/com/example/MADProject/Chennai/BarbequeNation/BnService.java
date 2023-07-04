package com.example.MADProject.Chennai.BarbequeNation;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("BnService")
public class BnService {

    @Autowired
    private BnRepo repository;


    @Transactional
    public List<BnModel> getAllProducts(){
        return repository.findAll();
    }

    @Transactional
    public BnModel getProductById(int id){
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public BnModel createProduct(BnModel product){
        return repository.save(product);
    }

    
    @Transactional
    public BnModel updateProduct(int id, BnModel product){
        BnModel productItem = repository.findById(id).orElse(null);

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
