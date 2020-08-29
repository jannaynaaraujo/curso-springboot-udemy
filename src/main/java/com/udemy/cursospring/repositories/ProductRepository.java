package com.udemy.cursospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.cursospring.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
