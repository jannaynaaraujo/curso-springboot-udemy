package com.udemy.cursospring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.cursospring.domain.Client;
import com.udemy.cursospring.repositories.ClientRepository;
import com.udemy.cursospring.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public List<Client> getClients(){
		return clientRepository.findAll();
	}
	
	public Client getClientById(Integer id) {
		return clientRepository.findById(id).orElseThrow(
				() -> new ObjectNotFoundException("Client not found. Id = " + id)
			);
	}

}
