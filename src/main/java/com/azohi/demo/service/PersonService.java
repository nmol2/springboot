package com.azohi.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.azohi.demo.dao.PersonDao;
import com.azohi.demo.model.Person;

@Service
public class PersonService {

	private final PersonDao personDao;
	
	@Autowired
	public PersonService(@Qualifier("personDaoImplPostgres") PersonDao personDao) {
		this.personDao = personDao;
	}
	public int addPerson(Person person) {
		return personDao.insertPerson(person);
	}
	
	public List<Person> getAllPeople() {
		return personDao.selectAllPeople();		
	}
	
	public Optional<Person> getPersonById(UUID id) {
		return personDao.selectPersonById(id);		
	}
	
	public int deletePerson(UUID id) {
		return personDao.deletePrrsonById(id);
	}
	
	public int updatePerson(UUID id, Person newPerson) {
		return personDao.updatePrrsonById(id, newPerson);
	}
	
}
