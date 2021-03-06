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
//	getPersonInfoByLastName();
	getPersonInfoByFirstNameAndEmail();
	}

	private void getPersonInfoByFirstNameAndEmail() {
		// TODO Auto-generated method stub
		List<Person> peronList=peopleManagementService.getPersonInfoByFirstNameAndEmail("veeru","veeru@gmail.com");
		peronList.forEach(System.out::println);
	}

	private void getPersonInfoByLastName() {
		// TODO Auto-generated method stub
		List<Person> personList=peopleManagementService.getPersonInfoByLastName("kumar");
		personList.forEach(System.out::println);
		
	}
}
