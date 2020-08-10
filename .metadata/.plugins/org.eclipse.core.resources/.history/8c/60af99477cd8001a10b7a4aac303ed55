package com.gs.dao;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;

import com.gs.entities.Person;

public interface PeopleManagementDao extends CrudRepository<Person, Integer> {
	@Async
	CompletableFuture<Person> findByEmail(String email);
}
