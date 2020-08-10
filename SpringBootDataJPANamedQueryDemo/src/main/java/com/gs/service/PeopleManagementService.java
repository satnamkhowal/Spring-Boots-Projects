package com.gs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.dao.PeopleManagementDao;
import com.gs.entities.Person;
@Service
public class PeopleManagementService {
		@Autowired
		private PeopleManagementDao peopleManagementDao;

		public List<Person> getPersonInfoByLastName(String lastName) {
			// TODO Auto-generated method stub
			return peopleManagementDao.getDetailByLastName(lastName);
		}

		public List<Person> getPersonInfoByFirstNameAndEmail(String firstName, String email) {
			// TODO Auto-generated method stub
			return peopleManagementDao.getByFirstNameAndEmail(firstName, email);
		}

		
}
