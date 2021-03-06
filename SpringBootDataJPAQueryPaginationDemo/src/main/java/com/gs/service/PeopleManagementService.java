package com.gs.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gs.dao.PeopleManagementDao;
import com.gs.entities.Person;
@Service
public class PeopleManagementService {
		@Autowired
		private PeopleManagementDao peopleManagementDao;

		public CompletableFuture<Person> findByEmail(String email) {
			// TODO Auto-generated method stub
			return peopleManagementDao.findByEmail(email);
		}


		

		
}
