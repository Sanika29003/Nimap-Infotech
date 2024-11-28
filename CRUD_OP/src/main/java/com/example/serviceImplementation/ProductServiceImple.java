package com.example.serviceImplementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.model.Category;
import com.example.model.Product;
import com.example.repository.ProductRepo;
import com.example.service.ProductService;

@Service
public class ProductServiceImple implements ProductService{
	@Autowired
	ProductRepo productRepo;

	@Override
	public Page<Product> getAllProducts(Pageable pageable) {
		// TODO Auto-generated method stub
		return productRepo.findAll(pageable);
	}

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepo.save(product);
	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return productRepo.findById(id).get();
	}

	@Override
	public Product updateProductById(int id, Product product) {
		// TODO Auto-generated method stub

		 Optional<Product> product1 = productRepo.findById(id);
	                //.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));
	        
	        product.setName(product.getName());
	        product.setPrice(product.getPrice());
	        product.setCategory(product.getCategory());
	        
	        return productRepo.save(product);
		
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		
		boolean status =false;
		if(id!=0)
		{
			productRepo.deleteById(id);
			status=true;
		}
		return status;
		
	}

	
	

}
