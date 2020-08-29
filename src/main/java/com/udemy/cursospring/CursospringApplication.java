package com.udemy.cursospring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.udemy.cursospring.domain.Address;
import com.udemy.cursospring.domain.Category;
import com.udemy.cursospring.domain.City;
import com.udemy.cursospring.domain.Client;
import com.udemy.cursospring.domain.Product;
import com.udemy.cursospring.domain.State;
import com.udemy.cursospring.domain.enums.ClientType;
import com.udemy.cursospring.repositories.AddressRepository;
import com.udemy.cursospring.repositories.CategoryRepository;
import com.udemy.cursospring.repositories.CityRepository;
import com.udemy.cursospring.repositories.ClientRepository;
import com.udemy.cursospring.repositories.ProductRepository;
import com.udemy.cursospring.repositories.StateRepository;

@SpringBootApplication
public class CursospringApplication implements CommandLineRunner{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private AddressRepository addressRepository;

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
		
		State sp = new State(null, "SP");
		State mg = new State(null, "MG");
		
		City saoPaulo = new City(null, "São Paulo", sp);
		City campinas = new City(null, "Campinas", sp);
		City beloHorizonte = new City(null, "Belo Horizonte", mg);
		
		sp.getCities().addAll(Arrays.asList(saoPaulo, campinas));
		mg.getCities().add(beloHorizonte);
		
		stateRepository.saveAll(Arrays.asList(sp, mg));
		cityRepository.saveAll(Arrays.asList(saoPaulo, campinas, beloHorizonte));
		
		Client jannayna = new Client(null, "Jannayna Araujo", "jannayna@Gmail.com", "10008065454", ClientType.PESSOA_FISICA);
		jannayna.getPhones().addAll(Arrays.asList("83996548665", "41996548665"));
		
		Address address1 = new Address(null, "Rua Eduardo Carlos Pereira", 3234, "ap 102", "Portão", "80610-170", saoPaulo, jannayna);
		Address address2 = new Address(null, "Rua Paraiba", 847, "ap 31", "Guaíra", "80100-170", beloHorizonte, jannayna);
		
		jannayna.getAddresses().addAll(Arrays.asList(address1, address2));
		
		clientRepository.save(jannayna);
		addressRepository.saveAll(Arrays.asList(address1, address2));
	}

}
