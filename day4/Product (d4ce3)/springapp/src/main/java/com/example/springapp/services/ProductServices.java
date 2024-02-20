package com.example.springapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.example.springapp.model.Product;
import com.example.springapp.repository.ProductRepo;

@Service
public class ProductServices {
    
    @Autowired
    private ProductRepo productRepo;

    public boolean addProduct(Product product)
    {
        try{
            productRepo.save(product);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public List<Product> getProducts()
    {
        return productRepo.findAll();
    }

    public Product getProductById(int productId)
    {
        return productRepo.findById(productId).orElse(null);
    }
}
