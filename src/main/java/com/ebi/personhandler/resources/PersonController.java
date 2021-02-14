package com.ebi.personhandler.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebi.personhandler.dto.PersonDTO;
import com.ebi.personhandler.model.Person;
import com.ebi.personhandler.service.PersonService;

@RestController
@RequestMapping("/personhandler")
public class PersonController {

	@Autowired
	private PersonService service;

	// creating a post mapping that creates a specific person in H2 in-memory DB
	@PostMapping("/create")
	public String createUser(@RequestBody List<PersonDTO> request) {
		service.createUsers(request);
		return "Created users";
	}

	// creating a put mapping that updates the detail of a specific person
	@PutMapping("/update/{id}")
	public String updatePerson(@PathVariable("id") int id, @RequestBody PersonDTO request) {	
		return service.updateUser(id,request);
	}

	// creating a get mapping that retrieves the detail of a specific person
	@GetMapping("/person/{id}")
	public Person getUser(@PathVariable("id") int id) {
		return service.getPersonById(id);
	}

	// creating a delete mapping that deletes a specific person
	@DeleteMapping("/person/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		service.delete(id);
	}
}
