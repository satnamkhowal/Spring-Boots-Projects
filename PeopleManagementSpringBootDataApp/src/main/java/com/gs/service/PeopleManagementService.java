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

		public Person createPerson(Person p) {
			// TODO Auto-generated method stub
			return peopleManagementDao.save(p);
		}

		public Iterable<Person> createPerson(List<Person> persons) {
			// TODO Auto-generated method stub
			return peopleManagementDao.saveAll(persons);
		}

		public Iterable<Person> getPersonByIds(List<Integer> ids) {
			// TODO Auto-generated method stub
			return peopleManagementDao.findAllById(ids);
		}

		public void deletePersonEntity(Person person) {
			// TODO Auto-generated method stub
			peopleManagementDao.delete(person);			
		}

		public void updatePersonEmailById(int id, String newEmail) {
			// TODO Auto-generated method stub
			Person person=peopleManagementDao.findById(id).orElse(new Person());
			if(id==person.getId()) {
				person.setEmail(newEmail);
			}
			peopleManagementDao.save(person);
			
		}
}
