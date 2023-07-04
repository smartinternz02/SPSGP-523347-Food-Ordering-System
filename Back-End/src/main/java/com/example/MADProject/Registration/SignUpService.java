package com.example.MADProject.Registration;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("SignUpService")
public class SignUpService {

    @Autowired
    private SignUpRepo repository;


    @Transactional
    public List<SignUpModel> getAllProducts(){
        return repository.findAll();
    }

    @Transactional
    public SignUpModel getProductById(int id){
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public SignUpModel createProduct(SignUpModel product){
        return repository.save(product);
    }

    
    @Transactional
    public SignUpModel updateProduct(int id, SignUpModel product){
        SignUpModel productItem = repository.findById(id).orElse(null);

        productItem.setName(product.getName());
        productItem.setEmail(product.getEmail());
        productItem.setPassword(product.getPassword());
        
        return repository.save(productItem);

    }

    @Transactional    
    public void deleteProduct(int id){
        repository.deleteById(id);
    }

}
