package io.github.jonathan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.jonathan.controller.DTO.PersonDTO;
import io.github.jonathan.repository.PersonRepository;
import io.github.jonathan.service.PersonService;

@RestController
@RequestMapping("/v2/person")
@CrossOrigin("http://localhost:4200")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	
	@GetMapping("/get-all")
	public List<PersonDTO> getAllPerson(){
		return personService.getPerso();
	}
	
	
}
