package com.udemy.cursospring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.cursospring.domain.Request;
import com.udemy.cursospring.repositories.RequestRepository;
import com.udemy.cursospring.services.exceptions.ObjectNotFoundException;

@Service
public class RequestService {
	
	@Autowired
	private RequestRepository requestRepository;
	
	public List<Request> getRequests(){
		return requestRepository.findAll();
	}
	
	public Request getRequestById(Integer id) {
		return requestRepository.findById(id).orElseThrow(
				() -> new ObjectNotFoundException("Request not found. Id = " + id)
			);
	}

}