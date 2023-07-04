package com.example.MADProject.Hyderabad.Kebabs;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("KebabsService")
public class KebabsService {

    @Autowired
    private KebabsRepo repository;


    @Transactional
    public List<KebabsModel> getAllProducts(){
        return repository.findAll();
    }

    @Transactional
    public KebabsModel getProductById(int id){
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public KebabsModel createProduct(KebabsModel product){
        return repository.save(product);
    }

    
    @Transactional
    public KebabsModel updateProduct(int id, KebabsModel product){
        KebabsModel productItem = repository.findById(id).orElse(null);

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
