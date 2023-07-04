package com.example.MADProject.Registration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/SignUp")
public class SignUpController {
    
    @Autowired
    @Qualifier("SignUpService")
    private SignUpService productService;

    @CrossOrigin
    @GetMapping("")
    public List<SignUpModel> getAllProducts(){
        return productService.getAllProducts();
    }

    @CrossOrigin
    @PostMapping("/save")
    public SignUpModel createProduct(@RequestBody SignUpModel product){
        return productService.createProduct(product);
    }


    
    
}
