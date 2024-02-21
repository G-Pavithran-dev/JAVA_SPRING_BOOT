package com.example.springapp.service;

import org.springframework.stereotype.Service;

import com.example.springapp.model.Product;
import com.example.springapp.repo.ProductRepo;

@Service
public class ProductService {
    
    private ProductRepo productRepo;
    public ProductService(ProductRepo productRepo)
    {
        this.productRepo = productRepo;
    }

    public Boolean saveProduct(Product product)
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

    public Product searchById(int id)
    {
        return productRepo.findById(id).orElse(null);
    }

    public Boolean deleteById(int id)
    {
        if(this.searchById(id) == null)
            return false;
        
        try{
            productRepo.deleteById(id);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public Boolean updateById(int id, Product product)
    {
        if(this.searchById(id) == null)
            return false;
        
        try{
            productRepo.save(product);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
}
