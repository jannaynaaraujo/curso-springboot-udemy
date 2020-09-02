package com.udemy.cursospring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.cursospring.domain.Request;
import com.udemy.cursospring.services.RequestService;

@RestController
@RequestMapping(value = "/request")
public class RequestController {
	
	@Autowired
	private RequestService requestService;
	
	@RequestMapping(value = "/requests", method = RequestMethod.GET)
	public ResponseEntity<List<Request>> getRequests(){
		return ResponseEntity.ok().body(requestService.getRequests());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Request> getRequestById(@PathVariable Integer id){
		return ResponseEntity.ok().body(requestService.getRequestById(id));
	}

}
