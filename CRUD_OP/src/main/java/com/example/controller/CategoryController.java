package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Category;
import com.example.service.CategoryService;

@RestController
@CrossOrigin
@RequestMapping("/api/categories")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("getAllCategories")
	public Page<Category> getAllCategories(Pageable pageable) {
        return categoryService.getAllCategories(pageable);
    }
	
	 @PostMapping("addCat")
	    public Category createCategory(@RequestBody Category category) {
	        return categoryService.addCategory(category);
	    }
	 
	 @GetMapping("/{id}")
	    public Category getCategoryById(@PathVariable int id)
	 
	    {
	        return categoryService.getCategoryById(id);
	    }
	 
	 @PutMapping("/{id}")
	    public Category updateCategoryById(@PathVariable int id, @RequestBody Category categoryDetails) {
	        return categoryService.updateCategoryById(id, categoryDetails);
	    }
	 
	 @DeleteMapping("deletebyid/{id}")
		public boolean deletebyid(@PathVariable int id)
		{
			return categoryService.deletebyid(id);
		}

}
