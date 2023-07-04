package com.example.MADProject.Vellore.AndhraSpice;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("andhraProductService")
public class AndhraService {

    @Autowired
    private AndhraSpiceRepo repository;


    @Transactional
    public List<AndhraSpiceModel> getAllProducts(){
        return repository.findAll();
    }

    @Transactional
    public AndhraSpiceModel getProductById(int id){
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public AndhraSpiceModel createProduct(AndhraSpiceModel product){
        return repository.save(product);
    }

    
    @Transactional
    public AndhraSpiceModel updateProduct(int id, AndhraSpiceModel product){
        AndhraSpiceModel productItem = repository.findById(id).orElse(null);

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
