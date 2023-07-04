package com.example.MADProject.Bangalore.IndianDarbar;

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
@RequestMapping("/IDarbar")
public class DarbarController {
    
    @Autowired
    @Qualifier("DarbarService")
    private DarbarService productService;

    @CrossOrigin
    @GetMapping("")
    public List<DarbarModel> getAllProducts(){
        return productService.getAllProducts();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public DarbarModel getProductById(@PathVariable int id){
        return productService.getProductById(id);
    }

    @PostMapping("")
    public DarbarModel createProduct(@RequestBody DarbarModel product){
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public DarbarModel createProductById(@PathVariable int id, @RequestBody DarbarModel Product){
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
