package com.example.MADProject.Chennai.SarvanaBhavan;

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
@RequestMapping("/Sb")
public class SbController {
    
    @Autowired
    @Qualifier("SbService")
    private SbService productService;

    @CrossOrigin
    @GetMapping("")
    public List<SbModel> getAllProducts(){
        return productService.getAllProducts();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public SbModel getProductById(@PathVariable int id){
        return productService.getProductById(id);
    }

    @PostMapping("")
    public SbModel createProduct(@RequestBody SbModel product){
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public SbModel createProductById(@PathVariable int id, @RequestBody SbModel Product){
        return productService.updateProduct(id, Product);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/")
    public String home() {
        return "productList.html"; }

}
