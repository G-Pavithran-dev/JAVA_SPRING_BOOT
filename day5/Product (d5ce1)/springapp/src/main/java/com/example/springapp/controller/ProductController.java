package com.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Product;
import com.example.springapp.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService ser;

    @PostMapping("/product")
    public ResponseEntity<Product> add (@RequestBody Product pro)
    {
        if(ser.saveProduct(pro))
        {
            return new ResponseEntity<Product>(pro,HttpStatus.CREATED);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



     @PutMapping("/product/{productId}")
    public ResponseEntity<String> update (@RequestParam int userName,@RequestBody Product signUp)
    {
        if(ser.updateById(userName,signUp))
        {
            return new ResponseEntity<String>("Update Successfull",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<String>("Not able to Update",HttpStatus.NOT_FOUND);
        }
    }



    @DeleteMapping("/product/{productId}")
    public ResponseEntity<Product> deleteById(@PathVariable int userName)
    {
        if(ser.deleteById(userName)==true)
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}