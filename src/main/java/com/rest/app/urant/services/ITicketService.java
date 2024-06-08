package com.rest.app.urant.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.app.urant.dao.ITicketDao;
import com.rest.app.urant.models.Ticket;

@Component
public class ITicketService implements IService<Ticket, Ticket>{
	@Autowired
	ITicketDao ticketDao;

	@Override
	public List<Ticket> listar() {
		List<Ticket> ticket = new ArrayList<>();
		ticket = (List<Ticket>) ticketDao.findAll();
		return ticket;
	}

	@Override
	public Optional<Ticket> getById(Long id) {
		Optional<Ticket> ticket = ticketDao.findById(id);
		return ticket;
	}

	@Override
	public void guardar(Ticket t) {
		this.ticketDao.save(t);
		
	}

	@Override
	public void eliminar(Long id) {
		this.ticketDao.deleteById(id);
		
	}
}
