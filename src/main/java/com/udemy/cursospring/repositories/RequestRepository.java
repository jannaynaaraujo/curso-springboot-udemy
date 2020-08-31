package com.udemy.cursospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.cursospring.domain.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {

}
