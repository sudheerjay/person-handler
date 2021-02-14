package com.ebi.personhandler.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ebi.personhandler.dto.PersonDTO;
import com.ebi.personhandler.model.Person;

@Service
public interface PersonService {

	void createUsers(List<PersonDTO> request);

	String updateUser(int id, PersonDTO request);

	void delete(int id);

	Person getPersonById(int id);

}
