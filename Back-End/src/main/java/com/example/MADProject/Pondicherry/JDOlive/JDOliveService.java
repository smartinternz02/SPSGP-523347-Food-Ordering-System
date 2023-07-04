package com.example.MADProject.Pondicherry.JDOlive;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("JDOService")
public class JDOliveService {

    @Autowired
    private JDOliveRepo repository;


    @Transactional
    public List<JDOliveModel> getAllProducts(){
        return repository.findAll();
    }

    @Transactional
    public JDOliveModel getProductById(int id){
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public JDOliveModel createProduct(JDOliveModel product){
        return repository.save(product);
    }

    
    @Transactional
    public JDOliveModel updateProduct(int id, JDOliveModel product){
        JDOliveModel productItem = repository.findById(id).orElse(null);

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
