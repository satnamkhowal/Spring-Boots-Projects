package com.gs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

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
			Pageable pageable=PageRequest.of(0, 3, Direction.ASC,"firstName");
			List<Person> list=peopleManagementService.findByLastName("Kumar",pageable);
			list.forEach(System.out::println);
	}

}
