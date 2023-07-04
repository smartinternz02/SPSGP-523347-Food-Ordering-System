package com.example.MADProject.Vellore.VelloreKitchen;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
@Qualifier("velloreProductService")
public class ProductService {

    @Autowired
    private productRepository repository;
    
    @Transactional
    public List<productItemModel> getAllProducts(){
        return repository.findAll();
    }

    @Transactional
    public productItemModel getProductById(int id){
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public productItemModel createProduct(productItemModel product){
        return repository.save(product);
    }

    // @Query(value ="select * from vellore_kitchen v where v.id = ?1", nativeQuery = true)
    // public productItemModel getProductById(Integer id)

    @Transactional
    public productItemModel updateProduct(int id, productItemModel product){
        productItemModel productItem = repository.findById(id).orElse(null);

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
