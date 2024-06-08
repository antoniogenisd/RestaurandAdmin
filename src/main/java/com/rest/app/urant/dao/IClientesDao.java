package com.rest.app.urant.dao;

import org.springframework.data.repository.CrudRepository;

import com.rest.app.urant.models.Cliente;

public interface IClientesDao extends CrudRepository<Cliente, Long> {

}
