package com.rest.app.urant.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.app.urant.dtos.OrdenTDO;
import com.rest.app.urant.models.Ordenes;
import com.rest.app.urant.services.IService;

@RestController
@RequestMapping("/api/ordenes")
@CrossOrigin(origins = "*")

public class OrenesController {
	
	@Autowired
	IService<Ordenes, OrdenTDO> ordenIService;
	
	@PostMapping
	public Map<String, String> guardar(@RequestBody OrdenTDO o) {
		ordenIService.guardar(o);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Orden guardada correctaente");
		return respuesta;
	}

	@GetMapping
	public List<Ordenes> listar() {
		return ordenIService.listar();
	}

	@GetMapping("/obtener/{id}")
	public Ordenes obtenerPorId(@PathVariable(name = "id") Long id) {
		Optional<Ordenes> orden = ordenIService.getById(id);
		if (orden.isPresent()) {
			return orden.get();
		} else {
			return null;
		}
	}

	@DeleteMapping("/eliminar")
	public Map<String, String> eliminar(@RequestParam(name = "id") Long id) {
		ordenIService.eliminar(id);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Orden eliminada correctamente");
		return respuesta;
	}

	@PutMapping("/actualizar/{id}")
	public Map<String, String> actualizar(@RequestBody OrdenTDO o, @PathVariable(name = "id") Long id) {
		Optional<Ordenes> orden = ordenIService.getById(id);
		if (orden.isPresent()) {
			o.setId(id);
			ordenIService.guardar(o);
		} else {
			throw new RuntimeException("La orden no existe en la BD");
		}
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Orden actualizada correctamente");
		return respuesta;
	}

}
