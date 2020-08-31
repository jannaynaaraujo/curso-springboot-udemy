package com.udemy.cursospring;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.udemy.cursospring.domain.Address;
import com.udemy.cursospring.domain.Category;
import com.udemy.cursospring.domain.City;
import com.udemy.cursospring.domain.Client;
import com.udemy.cursospring.domain.Payment;
import com.udemy.cursospring.domain.PaymentWithCard;
import com.udemy.cursospring.domain.PaymentWithSlip;
import com.udemy.cursospring.domain.Product;
import com.udemy.cursospring.domain.Request;
import com.udemy.cursospring.domain.State;
import com.udemy.cursospring.domain.enums.ClientType;
import com.udemy.cursospring.domain.enums.PaymentStatus;
import com.udemy.cursospring.repositories.AddressRepository;
import com.udemy.cursospring.repositories.CategoryRepository;
import com.udemy.cursospring.repositories.CityRepository;
import com.udemy.cursospring.repositories.ClientRepository;
import com.udemy.cursospring.repositories.PaymentRepository;
import com.udemy.cursospring.repositories.ProductRepository;
import com.udemy.cursospring.repositories.RequestRepository;
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
	
	@Autowired
	private RequestRepository requestRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;

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
		
		Client jannayna = new Client(null, "Jannayna Araujo", "jannayna@Gmail.com", "10008065454", ClientType.PHYSICAL_PERSON);
		jannayna.getPhones().addAll(Arrays.asList("83996548665", "41996548665"));
		
		Address address1 = new Address(null, "Rua Eduardo Carlos Pereira", 3234, "ap 102", "Portão", "80610-170", saoPaulo, jannayna);
		Address address2 = new Address(null, "Rua Paraiba", 847, "ap 31", "Guaíra", "80100-170", beloHorizonte, jannayna);
		
		jannayna.getAddresses().addAll(Arrays.asList(address1, address2));
		
		clientRepository.save(jannayna);
		addressRepository.saveAll(Arrays.asList(address1, address2));
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Request request1 = new Request(null, simpleDateFormat.parse("01/09/2020 20:00"), jannayna, address1);
		Request request2 = new Request(null, simpleDateFormat.parse("02/09/2021 20:00"), jannayna, address2);
		
		Payment payment1 = new PaymentWithCard(null, PaymentStatus.SETTLED, request1, 10);
		Payment payment2 = new PaymentWithSlip(null, PaymentStatus.PENDING, request2, simpleDateFormat.parse("02/09/2021 20:00") , null);
		
		request1.setPayment(payment1);
		request2.setPayment(payment2);
		
		jannayna.getRequests().addAll(Arrays.asList(request1, request2));
		
		requestRepository.saveAll(Arrays.asList(request1, request2));
		paymentRepository.saveAll(Arrays.asList(payment1, payment2));
	}

}
