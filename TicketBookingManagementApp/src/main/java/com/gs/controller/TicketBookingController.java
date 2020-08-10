package com.gs.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gs.entities.Ticket;
import com.gs.service.TicketBookingService;

@RestController
@RequestMapping(value="/api/tickets")
public class TicketBookingController {
			@Autowired
			private TicketBookingService ticketBookingService;
			
			@PostMapping("/create")
			public Ticket createTicket(@RequestBody Ticket ticket) {
				return ticketBookingService.createTicket(ticket);
			}
			
			@GetMapping("/ticket/{ticketId}")
			public Optional<Ticket> getTicketById(@PathVariable("ticketId") Integer ticketId) {
				return ticketBookingService.getTicketById(ticketId);
			}
			
			@GetMapping("/ticket/alltickets")
			public Iterable<Ticket> getAllBookedTickets(){
				return ticketBookingService.getAllBookedTickets();
			}
			@DeleteMapping("/ticket/{ticketId}")
			public void deleteTicket(@PathVariable("ticketId") Integer ticketId) {
				ticketBookingService.deleteTicket(ticketId);
			}
			@PutMapping(value="/ticket/{ticketId}/{newEmail:.+}")
			public Ticket updateTicket(@PathVariable("ticketId")Integer ticketId,@PathVariable("newEmail") String newEmail) {
				return ticketBookingService.updateTicket(ticketId,newEmail);
			}
			
			
}
