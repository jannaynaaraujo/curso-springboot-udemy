package com.udemy.cursospring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.cursospring.domain.Category;
import com.udemy.cursospring.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> getCategories() {
		return categoryRepository.findAll();
	}
	
	public Category getCategoryById(Integer id) {
		return categoryRepository.findById(id).orElse(null);
	}

}
