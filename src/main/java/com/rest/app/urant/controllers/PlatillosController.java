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

import com.rest.app.urant.models.Platillo;
import com.rest.app.urant.services.IService;

@RestController
@RequestMapping("/api/platillos")
@CrossOrigin(origins = "*")

public class PlatillosController {
	
	@Autowired
	IService<Platillo, Platillo> platiIService;
	
	@PostMapping
	public Map<String, String> guardar(@RequestBody Platillo p) {
		platiIService.guardar(p);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "platillo guardado correctaente");
		return respuesta;
	}

	@GetMapping
	public List<Platillo> listar() {
		return platiIService.listar();
	}

	@GetMapping("/obtener/{id}")
	public Platillo obtenerPorId(@PathVariable(name = "id") Long id) {
		Optional<Platillo> platillo = platiIService.getById(id);
		if (platillo.isPresent()) {
			return platillo.get();
		} else {
			return null;
		}
	}

	@DeleteMapping("/eliminar")
	public Map<String, String> eliminar(@RequestParam(name = "id") Long id) {
		platiIService.eliminar(id);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "platillo eliminado correctamente");
		return respuesta;
	}

	@PutMapping("/actualizar/{id}")
	public Map<String, String> actualizar(@RequestBody Platillo p, @PathVariable(name = "id") Long id) {
		Optional<Platillo> platillo = platiIService.getById(id);
		if (platillo.isPresent()) {
			p.setId(id);
			platiIService.guardar(p);
		} else {
			throw new RuntimeException("El platillo no existe en la BD");
		}
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Platillo actualizado correctamente");
		return respuesta;
	}
}
