package com.ebi.personhandler.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ebi.personhandler.model.Person;

@Repository
@Transactional
public interface PersonRepository extends CrudRepository<Person, Integer>{
	
	@Query(value = "SELECT * from PERSON WHERE (first_name =:first_name) and (last_name =:last_name);", nativeQuery = true)
	Person findByFirstNameAndLastName(@Param("first_name")String first_name, @Param("last_name")String last_name);
	
}
