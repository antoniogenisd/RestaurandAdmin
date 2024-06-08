package com.rest.app.urant.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.app.urant.dao.IClientesDao;
import com.rest.app.urant.dao.IEmpleadoDao;
import com.rest.app.urant.dao.IOrdenesDao;
import com.rest.app.urant.dtos.OrdenTDO;
import com.rest.app.urant.models.Ordenes;

@Component
public class IOrdenesServices implements IService<Ordenes, OrdenTDO>{

	@Autowired
	IOrdenesDao ordenesDao;

	@Autowired
	private IClientesDao clientesDao;
	
	@Autowired
	private IEmpleadoDao empleadoDao;
	
	@Override
	public List<Ordenes> listar() {
		List<Ordenes> ordenes = new ArrayList<>();
		ordenes = (List<Ordenes>) ordenesDao.findAll();
		return ordenes;
	}

	@Override
	public Optional<Ordenes> getById(Long id) {
		Optional<Ordenes> empleado = ordenesDao.findById(id);
		return empleado;
	}

	@Override
	public void guardar(OrdenTDO t) {
		this.ordenesDao.save(covertirDTOaOrden(t));
		
	}

	@Override
	public void eliminar(Long id) {
		this.ordenesDao.deleteById(id);
		
	}
	
	//metodo para convertir el dto al original
			private Ordenes covertirDTOaOrden(OrdenTDO odendto) {
				Ordenes o = new Ordenes();		
				o.setId(odendto.getId());
				o.setFecha(odendto.getFecha());
				o.setTotal(odendto.getTotal());
				o.setSubtotal(odendto.getSubtotal());
				o.setEmpleado(empleadoDao.findById(odendto.getEmpleado()).get());
				o.setCliente(clientesDao.findById(odendto.getCliente()).get());
				return o;
			}
}
