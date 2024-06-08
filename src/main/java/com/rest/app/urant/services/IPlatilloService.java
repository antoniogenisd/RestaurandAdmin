package com.rest.app.urant.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.app.urant.dao.IPlatilloDao;
import com.rest.app.urant.models.Platillo;

@Component
public class IPlatilloService implements IService<Platillo, Platillo>{
	
	@Autowired
	IPlatilloDao platilloDao;

	@Override
	public List<Platillo> listar() {
		List<Platillo> platillo = new ArrayList<>();
		platillo = (List<Platillo>) platilloDao.findAll();
		return platillo;
	}

	@Override
	public Optional<Platillo> getById(Long id) {
		Optional<Platillo> empleado = platilloDao.findById(id);
		return empleado;
	}

	@Override
	public void guardar(Platillo t) {
		this.platilloDao.save(t);
		
	}

	@Override
	public void eliminar(Long id) {
		this.platilloDao.deleteById(id);
		
	}
}
