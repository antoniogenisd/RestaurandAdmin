package com.rest.app.urant.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.app.urant.dao.IClientesDao;
import com.rest.app.urant.models.Cliente;

@Component
public class IClientesService implements IService<Cliente, Cliente>{

	@Autowired
	IClientesDao clientesDao;
	
	@Override
	public List<Cliente> listar() {
		List<Cliente> clientes = new ArrayList<>();
		clientes = (List<Cliente>) clientesDao.findAll();
		return clientes;
	}

	@Override
	public Optional<Cliente> getById(Long id) {
		Optional<Cliente> cliente = clientesDao.findById(id);
		return cliente;
	}

	@Override
	public void guardar(Cliente t) {
		// TODO Auto-generated method 
		this.clientesDao.save(t);
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		this.clientesDao.deleteById(id);
	}

	public List<Cliente> findVentasByClienteId(Long clienteId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
