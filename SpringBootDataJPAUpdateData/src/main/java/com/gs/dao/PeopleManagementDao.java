package com.gs.dao;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

import com.gs.entities.Person;

public interface PeopleManagementDao extends CrudRepository<Person, Integer> {
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Person SET email=:newEmail WHERE id=:pid")
	void updatePersonEmailById(@Param("pid") int id,@Param("newEmail") String newEmail);
		
}
