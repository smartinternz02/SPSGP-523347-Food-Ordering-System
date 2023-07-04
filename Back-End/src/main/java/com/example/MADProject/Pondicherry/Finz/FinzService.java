package com.example.MADProject.Pondicherry.Finz;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("FinzService")
public class FinzService {

    @Autowired
    private FinzRepo repository;


    @Transactional
    public List<FinzModel> getAllProducts(){
        return repository.findAll();
    }

    @Transactional
    public FinzModel getProductById(int id){
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public FinzModel createProduct(FinzModel product){
        return repository.save(product);
    }

    
    @Transactional
    public FinzModel updateProduct(int id, FinzModel product){
        FinzModel productItem = repository.findById(id).orElse(null);

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
