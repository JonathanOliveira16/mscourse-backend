package io.github.jonathan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.jonathan.model.PersonVO;

public interface PersonRepository extends JpaRepository<PersonVO, Integer>{

}
