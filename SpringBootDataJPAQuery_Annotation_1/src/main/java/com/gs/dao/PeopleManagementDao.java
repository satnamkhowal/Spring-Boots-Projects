package com.gs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.gs.entities.Person;

public interface PeopleManagementDao extends CrudRepository<Person, Integer> {
	@Query("SELECT p FROM Person p WHERE p.lastName=?1")
	List<Person> getDetailByLastName(String lastName);
	@Query("SELECT p FROM Person p WHERE p.firstName=?1 and p.email=?2")
	List<Person> getByFirstNameAndEmail(String firstName,String lastName);

}
