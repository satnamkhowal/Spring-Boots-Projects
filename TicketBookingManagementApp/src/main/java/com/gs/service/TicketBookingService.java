package com.gs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.dao.TicketBookingDao;
import com.gs.entities.Ticket;
@Service
public class TicketBookingService {
			@Autowired
			private TicketBookingDao ticketBookingDao;

			public Ticket createTicket(Ticket ticket) {
				// TODO Auto-generated method stub
				return ticketBookingDao.save(ticket);
			}

			public Optional<Ticket> getTicketById(Integer ticketId) {
				// TODO Auto-generated method stub
				return ticketBookingDao.findById(ticketId);
			}

			public Iterable<Ticket> getAllBookedTickets() {
				// TODO Auto-generated method stub
				return ticketBookingDao.findAll();
			}

			public void deleteTicket(Integer ticketId) {
				// TODO Auto-generated method stub
				 ticketBookingDao.deleteById(ticketId);
			}

			public Ticket updateTicket(Integer ticketId, String newEmail) {
				// TODO Auto-generated method stub
				Ticket ticketfromDb=ticketBookingDao.findById(ticketId).orElse(new Ticket());
				ticketfromDb.setEmail(newEmail);
				return ticketBookingDao.save(ticketfromDb);
			}
			
}
