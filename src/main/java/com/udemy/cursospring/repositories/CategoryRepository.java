package com.udemy.cursospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.cursospring.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
