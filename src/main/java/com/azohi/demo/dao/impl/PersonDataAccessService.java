package com.azohi.demo.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.azohi.demo.dao.PersonDao;
import com.azohi.demo.model.Person;

@Repository("personDaoImpl")
public class PersonDataAccessService implements PersonDao {

	private static List<Person> persons = new ArrayList<>();
	
	@Override
	public int insertPerson(UUID id, Person person) {
		persons.add(new Person(id, person.getName()));
		return 1;
	}

	@Override
	public List<Person> selectAllPeople() {
		return persons;
	}

	@Override
	public Optional<Person> selectPersonById(UUID id) {		
		return persons.stream()
				.filter(person -> person.getId().equals(id))
				.findFirst();
	}

	@Override
	public int deletePrrsonById(UUID id) {
		Optional<Person> person = selectPersonById(id);
		if(person.isEmpty()) return 0;
		persons.remove(person.get());
		return 1;
	}

	@Override
	public int updatePrrsonById(UUID id, Person personWithUpdates) {
		return selectPersonById(id)
				.map(person -> {
					int indexOfPersonToUpdate = persons.indexOf(person);
					if(indexOfPersonToUpdate >= 0) {
						persons.set(indexOfPersonToUpdate, new Person(id, personWithUpdates.getName()));
						return 1;
					}
					return 0;
				})
				.orElse(0);
	}
	

}
