package com.niantic.controllers;

import com.niantic.services.ProductDao;
import org.springframework.web.bind.annotation.GetMapping;

public class ProductsController
{
    private ProductDao products = new ProductDao();

    @GetMapping("/products")
    public String getProducts(){
        return "products/index.html";
    }
}
