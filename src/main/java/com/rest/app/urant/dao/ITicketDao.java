package com.rest.app.urant.dao;

import org.springframework.data.repository.CrudRepository;

import com.rest.app.urant.models.Platillo;
import com.rest.app.urant.models.Ticket;

public interface ITicketDao extends CrudRepository<Ticket, Long>{

}
