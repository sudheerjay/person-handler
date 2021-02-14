package com.ebi.personhandler.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebi.personhandler.dto.PersonDTO;
import com.ebi.personhandler.model.Person;
import com.ebi.personhandler.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository repo;

	private static final Logger LOGGER = LoggerFactory.getLogger(PersonServiceImpl.class);

	@Override
	public void createUsers(List<PersonDTO> request) {

		try {
			request.forEach(personDTO -> {			
				Person person = new Person();
				mapDTOtoModel(person, personDTO);
				Person personFromDB = repo.save(person);
				LOGGER.info("Saved person with firstName: {} and LastName:{} to DB.", personFromDB.getFirst_name(),
						personFromDB.getLast_name());
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Person mapDTOtoModel(Person person, PersonDTO personDTO) {
		person.setAge(personDTO.getAge());
		person.setFirst_name(personDTO.getFirst_name());
		person.setLast_name(personDTO.getLast_name());
		person.setFavourite_colour(personDTO.getFavourite_colour());
		return person;
	}

	@Override
	public String updateUser(int id, PersonDTO personDTO) {
		Optional<Person> personFromDB = repo.findById(id);
		if(Objects.isNull(personFromDB.get())) {
			return "No records found for ID:"+id+". Unable to update";
		}
		Person person = mapDTOtoModel(personFromDB.get(), personDTO);
		repo.save(person);
		return "updated person with ID:"+person.getId();
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);
	}

	@Override
	public Person getPersonById(int id) {
		Optional<Person> personFromDB= repo.findById(id);
		if(Objects.nonNull(personFromDB.get())) {
			return personFromDB.get();
		}else {
			LOGGER.error("Couldn't find person with ID:{}", id);
		}
		return null;
	}

}
