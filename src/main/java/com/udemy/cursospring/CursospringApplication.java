package com.udemy.cursospring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.udemy.cursospring.domain.Category;
import com.udemy.cursospring.repositories.CategoryRepository;

@SpringBootApplication
public class CursospringApplication implements CommandLineRunner{
	
	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursospringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category informatica = new Category(null, "Informática");
		Category escritorio = new Category(null, "Escritório");
		
		categoryRepository.saveAll(Arrays.asList(informatica, escritorio));
		
	}

}
