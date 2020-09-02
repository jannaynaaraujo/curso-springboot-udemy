package com.udemy.cursospring.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.udemy.cursospring.domain.Category;
import com.udemy.cursospring.services.CategoryService;

@RestController
@RequestMapping(value = "category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "categories", method = RequestMethod.GET)
	public ResponseEntity<?> getCategories() {		
		return ResponseEntity.ok().body(categoryService.getCategories());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getCategoryById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(categoryService.getCategoryById(id));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createCategory(@RequestBody Category category){
		Category response = categoryService.createCategory(category);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(response.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}

}
