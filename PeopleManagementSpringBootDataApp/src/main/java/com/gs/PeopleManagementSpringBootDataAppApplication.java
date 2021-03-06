package com.gs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gs.entities.Person;
import com.gs.service.PeopleManagementService;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

@SpringBootApplication
public class PeopleManagementSpringBootDataAppApplication implements CommandLineRunner{

	@Autowired
	private PeopleManagementService peopleManagementService;
	public static void main(String[] args) {
		SpringApplication.run(PeopleManagementSpringBootDataAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		createPerson();
//		createPersons();
//		getPersonById();
//		deletePersonEntity();
		updatePersonEmailById();
	}

	private void updatePersonEmailById() {
		// TODO Auto-generated method stub
	peopleManagementService.updatePersonEmailById(2,"kishankumar123@gmail.com");
		
	}

	private void deletePersonEntity() {
		// TODO Auto-generated method stub
		Person person=new Person();
		person.setId(1);
		peopleManagementService.deletePersonEntity(person);
		
	}

	private void getPersonById() {
		// TODO Auto-generated method stub
		List<Integer> ids=new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		Iterable<Person> personList=peopleManagementService.getPersonByIds(ids);
		personList.forEach(System.out::println);
		
		
	}

	private void createPersons() {
		// TODO Auto-generated method stub
		List<Person> persons=Arrays.asList(new Person("kishan", "kumar", "kishan@gmail.com", new Date()),
				new Person("veeru", "chopra", "veeru@gmail.com", new Date()));
		Iterable<Person> createPerson=peopleManagementService.createPerson(persons);
		for (Person person : createPerson) {
			System.out.println(person);
		}
		
	}

	private void createPerson() {
		// TODO Auto-generated method stub
		Person p=new Person( "jai", "singh", "jai@gmail.com", new Date());
		Person pdb=peopleManagementService.createPerson(p);
		System.out.println(pdb);
	}

}
