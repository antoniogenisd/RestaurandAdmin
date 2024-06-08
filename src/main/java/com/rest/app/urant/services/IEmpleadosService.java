package com.rest.app.urant.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.app.urant.dao.IEmpleadoDao;
import com.rest.app.urant.models.Empleado;

@Component
public class IEmpleadosService implements IService<Empleado, Empleado> {
	
	@Autowired
	IEmpleadoDao empleadoDao;

	@Override
	public List<Empleado> listar() {
		List<Empleado> clientes = new ArrayList<>();
		clientes = (List<Empleado>) empleadoDao.findAll();
		return clientes;
	}

	@Override
	public Optional<Empleado> getById(Long id) {
		Optional<Empleado> empleado = empleadoDao.findById(id);
		return empleado;
	}

	@Override
	public void guardar(Empleado t) {
		this.empleadoDao.save(t);
	}

	@Override
	public void eliminar(Long id) {
		this.empleadoDao.deleteById(id);
		
	}
}
