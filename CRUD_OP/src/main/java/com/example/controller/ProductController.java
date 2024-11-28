package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	
	@GetMapping
    public Page<Product> getAllProducts(Pageable pageable) {
        return productService.getAllProducts(pageable);
    }
	
	@PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
	
	@GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }
	
	@PutMapping("/updateById")
    public Product updateProductById(@PathVariable int id, @RequestBody Product productDetails) {
        return productService.updateProductById(id, productDetails);
    }
	
	@DeleteMapping("/{id}")
	public boolean deletebyid(@PathVariable int id)
	{
		return productService.deleteById(id);
	}

}
