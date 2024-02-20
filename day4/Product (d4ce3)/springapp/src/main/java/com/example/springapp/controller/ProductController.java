package com.example.springapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Product;
import com.example.springapp.services.ProductServices;

@RestController
@RequestMapping("/api")
public class ProductController {
    
    private ProductServices productServices;
    public ProductController(ProductServices productServices)
    {
        this.productServices = productServices;
    }

    @PostMapping("/product")
    public ResponseEntity<Product> addData(@RequestBody Product product)
    {
        if(productServices.addProduct(product))
        {
            return new ResponseEntity<Product>(product, HttpStatus.CREATED);
        }
        else{
            System.out.println("Cannot add Object");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getList()
    {
        List<Product> products = productServices.getProducts();
        if(products.size() > 0)
        {
            return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<Product> getproductById(@PathVariable int productId){
        Product product = productServices.getProductById(productId);
        if(product != null)
        {
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
