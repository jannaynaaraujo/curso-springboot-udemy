package com.udemy.cursospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.cursospring.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

}
