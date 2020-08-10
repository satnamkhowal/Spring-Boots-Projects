package com.gs;

import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.gs.entities.Ticket;
import com.gs.service.TicketBookingService;

@SpringBootApplication
public class TicketBookingManagementAppApplication implements CommandLineRunner{
	@Autowired
	TicketBookingService ticketBookingService;
	@Autowired
	private DataSource ds;
	public static void main(String[] args) {
				ApplicationContext ap=	SpringApplication.run(TicketBookingManagementAppApplication.class, args);
				
				
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		
		
		Ticket ticket=new Ticket();
		ticket.setBookingDate(new Date());
		ticket.setDestStation("Mumbai");
		ticket.setSourceStation("Pune");
		ticket.setPassengerName("KK");
		ticket.setEmail("kk@yahoo.com");
		
		ticketBookingService.createTicket(ticket);
		System.out.println(ds);
	
	}

}
