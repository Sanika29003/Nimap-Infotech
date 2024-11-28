package com.example.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.model.Category;
import com.example.model.Product;

public interface ProductService {
	
	org.springframework.data.domain.Page<Product> getAllProducts(org.springframework.data.domain.Pageable pageable);
    Product addProduct(Product product);
    Product getProductById(int id);
    Product updateProductById(int id, Product product);
    boolean deleteById(int id);
	//Page<Category> getAllCategories(Pageable pageable);


}
