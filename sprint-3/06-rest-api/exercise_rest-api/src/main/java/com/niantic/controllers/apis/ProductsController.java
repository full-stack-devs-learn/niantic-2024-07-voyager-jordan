package com.niantic.controllers.apis;

import com.niantic.exceptions.GlobalExceptionHandler;
import com.niantic.exceptions.ResourceNotFoundException;
import com.niantic.models.HttpError;
import com.niantic.models.Product;
import com.niantic.services.CategoryDao;
import com.niantic.services.LoggingService;
import com.niantic.services.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductsController
{
    @Autowired
    private ProductDao productDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private GlobalExceptionHandler error;
    private LoggingService errorLog = new LoggingService("errors");
    private String resourceType = "Products";

    //todo: Error Handling & Log Errors

    @GetMapping
    public ResponseEntity<?> getAllProducts()
    {
        try
        {
            var results = productDao.getAllProducts();
            if (results == null)
            {
                ResourceNotFoundException ex = new ResourceNotFoundException(resourceType);
                return error.handleNotFound(ex);
            }
            return ResponseEntity.ok(results);
        }
        catch(Exception e)
        {
            return error.handleInternalServerError(e);
        }

    }

    @GetMapping(path = "{productId}")
    public ResponseEntity<?> getProduct(@PathVariable int productId)
    {
        try
        {
            var results = productDao.getProductById(productId);
            if (results == null)
            {
                ResourceNotFoundException ex = new ResourceNotFoundException(resourceType + " with id", String.valueOf(productId));
                return error.handleNotFound(ex);
            }
           return ResponseEntity.ok(results);
        }
        catch(Exception e)
        {
            return error.handleInternalServerError(e);
        }
    }

    @GetMapping(params = "catId")
    public ResponseEntity<?> getProductByCategoryId(@RequestParam int catId)
    {
        try
        {
            var category = categoryDao.getCategory(catId);
            if(category == null)
            {
                ResourceNotFoundException ex = new ResourceNotFoundException("Category with Id", String.valueOf(catId));
                return error.handleNotFound(ex);
            }

            var results = productDao.getProductsByCategoryId(catId);
            if (results == null || results.isEmpty())
            {
                ResourceNotFoundException ex = new ResourceNotFoundException(resourceType + " with category Id", String.valueOf(catId));
                return error.handleNotFound(ex);
            }
            return ResponseEntity.ok(results);
        }
        catch(Exception e)
        {
            return error.handleInternalServerError(e);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> addProduct(@RequestBody Product product)
    {
        try
        {
            var target = productDao.getProductByName(product.getProductName());
            if(target != null)
            {
                var error = new HttpError(HttpStatus.CONFLICT.value()
                        , HttpStatus.CONFLICT.toString()
                        , String.format("Product %s already exist", product.getProductName()));

                return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
            }
            productDao.addProduct(product);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        catch(Exception e)
        {
            return error.handleInternalServerError(e);
        }
    }

    @PutMapping(path = "{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> putProduct(@PathVariable int productId, @RequestBody Product product)
    {
        try
        {
            var target = productDao.getProductById(productId);
            if(target == null)
            {
                ResourceNotFoundException ex = new ResourceNotFoundException("Product with product id", String.valueOf(productId));
                return error.handleNotFound(ex);
            }
            productDao.updateProduct(productId, product);
            return ResponseEntity.noContent().build();
        }
        catch(Exception e)
        {
            return error.handleInternalServerError(e);
        }
    }

    @DeleteMapping(path = "{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteProduct(@PathVariable int productId)
    {
        try
        {
            var target = productDao.getProductById(productId);
            if(target == null)
            {
                ResourceNotFoundException ex = new ResourceNotFoundException("Product with product id", String.valueOf(productId));
                return error.handleNotFound(ex);
            }
            productDao.deleteProduct(productId);
            return ResponseEntity.noContent().build();
        }
        catch(Exception e)
        {
            return error.handleInternalServerError(e);
        }
    }
}
