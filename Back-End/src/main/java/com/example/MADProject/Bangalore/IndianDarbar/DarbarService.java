package com.example.MADProject.Bangalore.IndianDarbar;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("DarbarService")
public class DarbarService {

    @Autowired
    private DarbarRepo repository;


    @Transactional
    public List<DarbarModel> getAllProducts(){
        return repository.findAll();
    }

    @Transactional
    public DarbarModel getProductById(int id){
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public DarbarModel createProduct(DarbarModel product){
        return repository.save(product);
    }

    
    @Transactional
    public DarbarModel updateProduct(int id, DarbarModel product){
        DarbarModel productItem = repository.findById(id).orElse(null);

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
