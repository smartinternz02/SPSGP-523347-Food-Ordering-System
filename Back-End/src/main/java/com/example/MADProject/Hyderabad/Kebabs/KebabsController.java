package com.example.MADProject.Hyderabad.Kebabs;

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
@RequestMapping("/Kebabs")
public class KebabsController {
    
    @Autowired
    @Qualifier("KebabsService")
    private KebabsService productService;

    @CrossOrigin
    @GetMapping("")
    public List<KebabsModel> getAllProducts(){
        return productService.getAllProducts();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public KebabsModel getProductById(@PathVariable int id){
        return productService.getProductById(id);
    }

    @PostMapping("")
    public KebabsModel createProduct(@RequestBody KebabsModel product){
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public KebabsModel createProductById(@PathVariable int id, @RequestBody KebabsModel Product){
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
