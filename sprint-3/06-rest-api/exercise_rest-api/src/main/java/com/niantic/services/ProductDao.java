package com.niantic.services;

import com.niantic.models.Product;

import java.util.List;

public interface ProductDao
{
    List<Product> getAllProducts();

    Product getProductById(int productId);

    Product getProductByName(String productName);

    List<Product> getProductsByCategoryId(int categoryId);

    Product addProduct(Product product);

    void updateProduct(int productId, Product product);

    void deleteProduct(int productId);
}
