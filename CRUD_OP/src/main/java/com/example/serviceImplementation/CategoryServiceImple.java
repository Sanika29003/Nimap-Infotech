package com.example.serviceImplementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.model.Category;
import com.example.repository.CategoryRepo;
import com.example.service.CategoryService;

@Service
public class CategoryServiceImple implements CategoryService {
	@Autowired
	CategoryRepo categoryRepo;

	@Override
	public Page<Category> getAllCategories(Pageable pageable) {
		// TODO Auto-generated method stub
		return categoryRepo.findAll(pageable);
	}

	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepo.save(category);
	}

	@Override
	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub
		return categoryRepo.findById(id).get();
	}

	@Override
	public Category updateCategoryById(int id, Category category) {
		// TODO Auto-generated method stub
		Optional<Category> category1 = categoryRepo.findById(id);
	            //.orElseThrow(() -> new ResourceNotFoundException("Category not found for this id :: " + id));
        category.setName(category.getName());
        return categoryRepo.save(category);
	}

	@Override
	public boolean deletebyid(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
