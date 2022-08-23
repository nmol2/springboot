package com.azohi.demo.dao.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.azohi.demo.dao.PersonDao;
import com.azohi.demo.model.Person;

@Repository("personDaoImplPostgres")
public class ActualPersonDataAccessSecvice implements PersonDao {

	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public ActualPersonDataAccessSecvice(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
		
	@Override
	public int insertPerson(UUID id, Person person) {
		return 0;
	}

	@Override
	public List<Person> selectAllPeople() {
		final String query = "SELECT id, name FROM person";
		return jdbcTemplate.query(query, (resultSet,i) -> {
			UUID id = UUID.fromString(resultSet.getString("id"));
			String name = resultSet.getString("name");
			return new Person(id, name);
		});
	}

	@Override
	public Optional<Person> selectPersonById(UUID id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public int deletePrrsonById(UUID id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePrrsonById(UUID id, Person person) {
		// TODO Auto-generated method stub
		return 0;
	}

}
