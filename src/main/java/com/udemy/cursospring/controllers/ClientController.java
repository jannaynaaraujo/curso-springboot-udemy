package com.udemy.cursospring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.cursospring.services.ClientService;

@RestController
@RequestMapping(value = "/client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public ResponseEntity<?> getClients(){
		return ResponseEntity.ok().body(clientService.getClients());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getClientById(@PathVariable Integer id){
		return ResponseEntity.ok().body(clientService.getClientById(id));
	}
}
