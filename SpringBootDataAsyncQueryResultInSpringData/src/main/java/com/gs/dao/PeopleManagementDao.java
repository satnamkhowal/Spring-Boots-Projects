package com.gs.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.gs.entities.Person;

public interface PeopleManagementDao extends CrudRepository<Person, Integer> {
	List<Person> findByLastName(String lastName,Pageable pageable);
}
