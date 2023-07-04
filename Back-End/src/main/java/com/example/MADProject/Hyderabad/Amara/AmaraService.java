package com.example.MADProject.Hyderabad.Amara;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("AmaraService")
public class AmaraService {

    @Autowired
    private AmaraRepo repository;


    @Transactional
    public List<AmaraModel> getAllProducts(){
        return repository.findAll();
    }

    @Transactional
    public AmaraModel getProductById(int id){
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public AmaraModel createProduct(AmaraModel product){
        return repository.save(product);
    }

    
    @Transactional
    public AmaraModel updateProduct(int id, AmaraModel product){
        AmaraModel productItem = repository.findById(id).orElse(null);

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
