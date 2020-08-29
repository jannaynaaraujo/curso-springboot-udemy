package com.udemy.cursospring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.udemy.cursospring.domain.Category;
import com.udemy.cursospring.domain.Product;
import com.udemy.cursospring.repositories.CategoryRepository;
import com.udemy.cursospring.repositories.ProductRepository;

@SpringBootApplication
public class CursospringApplication implements CommandLineRunner{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursospringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category informatica = new Category(null, "Informática");
		Category escritorio = new Category(null, "Escritório");
		
		Product computador = new Product(null, "Computador", 2000.00);
		Product impressora = new Product(null, "Impressora", 800.00);
		Product mouse = new Product(null, "Mouse", 80.00);
		
		informatica.getProducts().addAll(Arrays.asList(computador, impressora, mouse));
		escritorio.getProducts().addAll(Arrays.asList(impressora));
		
		computador.getCategories().add(informatica);
		impressora.getCategories().addAll(Arrays.asList(informatica, escritorio));
		mouse.getCategories().add(informatica);
		
		
		categoryRepository.saveAll(Arrays.asList(informatica, escritorio));
		productRepository.saveAll(Arrays.asList(computador, impressora, mouse));
		
	}

}
