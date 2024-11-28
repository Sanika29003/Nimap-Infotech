package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.Category;

@Service
public interface CategoryService {
	
	org.springframework.data.domain.Page<Category> getAllCategories(org.springframework.data.domain.Pageable pageable);
	public Category addCategory(Category category);
	public Category getCategoryById(int id);
	//public List<Category> findAllCategory();
	public Category updateCategoryById(int id, Category category);
	public boolean deletebyid(int id);

}
