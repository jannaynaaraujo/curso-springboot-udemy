package com.udemy.cursospring.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.cursospring.domain.Category;

@RestController
@RequestMapping(value = "categories")
public class CategoryResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Category> getCategories() {
		
		Category category1 = new Category(1, "Informatica"); 
		Category category2 = new Category(2, "Escritorio"); 
		
		List<Category> categories = new ArrayList<>();
		categories.add(category1);
		categories.add(category2);
		
		return categories;
	}

}
