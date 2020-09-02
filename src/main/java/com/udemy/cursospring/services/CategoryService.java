package com.udemy.cursospring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.cursospring.domain.Category;
import com.udemy.cursospring.repositories.CategoryRepository;
import com.udemy.cursospring.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> getCategories() {
		return categoryRepository.findAll();
	}

	public Category getCategoryById(Integer id) {
		return categoryRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Category not found. Id = " + id));
	}

	public Category createCategory(Category category) {
		category.setId(null);
		return categoryRepository.save(category);
	}
	
	public Category updateCategory(Category category, Integer id) {
		category.setId(id);
		getCategoryById(id);
		return categoryRepository.save(category);
	}


}
