package io.github.jonathan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.github.jonathan.controller.DTO.PersonDTO;
import io.github.jonathan.model.PersonVO;
import io.github.jonathan.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository persoRepo;
	
	public List<PersonDTO> getPerso(){
		List<PersonDTO> listPerso = new ArrayList<>();
		List<PersonVO> perso = persoRepo.findAll();
		for(PersonVO p : perso) {
			listPerso.add(new PersonDTO(p.getPersonId(), p.getEmail()));
		}
		return listPerso;
	}
	
}
