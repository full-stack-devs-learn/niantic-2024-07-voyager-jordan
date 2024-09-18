package com.niantic.controllers.apis;

import com.niantic.models.Product;
import com.niantic.services.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController
{
    @Autowired
    ProductDao productDao;

    @GetMapping
    public List<Product> getAllProducts()
    {
        return productDao.getAllProducts();
    }

    @GetMapping(path = "/{productId}")
    public Product getProduct(@PathVariable int productId)
    {
        return productDao.getProductById(productId);
    }

    @GetMapping(params = "catId")
    public List<Product> getProductByCategoryId(@RequestParam int catId)
    {
        return productDao.getProductsByCategoryId(catId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product)
    {
        return productDao.addProduct(product);
    }

    @PutMapping(path = "/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putProduct(@PathVariable int productId, @RequestBody Product product)
    {
        productDao.updateProduct(productId, product);
    }

    @DeleteMapping(path = "/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable int productId)
    {
        productDao.deleteProduct(productId);
    }
}
