package com.gs.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gs.entities.Ticket;
@Repository
public interface TicketBookingDao extends CrudRepository<Ticket, Integer> {
			
}
