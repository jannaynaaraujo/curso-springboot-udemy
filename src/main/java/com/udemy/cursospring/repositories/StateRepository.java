package com.udemy.cursospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.cursospring.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
