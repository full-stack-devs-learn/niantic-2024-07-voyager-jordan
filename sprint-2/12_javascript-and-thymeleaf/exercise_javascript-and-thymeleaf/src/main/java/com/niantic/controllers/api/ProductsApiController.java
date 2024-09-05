package com.niantic.controllers.api;

import com.niantic.models.Product;
import com.niantic.services.ProductDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
public class ProductsApiController {

    private ProductDao productDao = new ProductDao();

    @GetMapping("/api/products/{categoryId}")
    public ArrayList<Product> getProductsByCategoryId(@PathVariable int categoryId)
    {
        ArrayList<Product> products;
        products = productDao.getProductsByCategory(categoryId);
        return products;
    }

}
