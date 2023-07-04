package com.example.MADProject.Bangalore.Tiamo;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("TiamoService")
public class TiamoService {

    @Autowired
    private TiamoRepo repository;


    @Transactional
    public List<TiamoModel> getAllProducts(){
        return repository.findAll();
    }

    @Transactional
    public TiamoModel getProductById(int id){
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public TiamoModel createProduct(TiamoModel product){
        return repository.save(product);
    }

    
    @Transactional
    public TiamoModel updateProduct(int id, TiamoModel product){
        TiamoModel productItem = repository.findById(id).orElse(null);

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
