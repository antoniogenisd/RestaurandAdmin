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

import com.rest.app.urant.models.Empleado;
import com.rest.app.urant.services.IService;

@RestController
@RequestMapping("/api/empleados")
@CrossOrigin(origins = "*")
public class EmpleadosController {
	
	@Autowired
	IService<Empleado, Empleado> empleIService;
	
	@PostMapping
	public Map<String, String> guardar(@RequestBody Empleado e) {
		empleIService.guardar(e);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "empleado guardado correctaente");
		return respuesta;
	}

	@GetMapping
	public List<Empleado> listar() {
		return empleIService.listar();
	}

	@GetMapping("/obtener/{id}")
	public Empleado obtenerPorId(@PathVariable(name = "id") Long id) {
		Optional<Empleado> empleado = empleIService.getById(id);
		if (empleado.isPresent()) {
			return empleado.get();
		} else {
			return null;
		}
	}

	@DeleteMapping("/eliminar")
	public Map<String, String> eliminar(@RequestParam(name = "id") Long id) {
		empleIService.eliminar(id);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Empleado eliminado correctamente");
		return respuesta;
	}

	@PutMapping("/actualizar/{id}")
	public Map<String, String> actualizar(@RequestBody Empleado c, @PathVariable(name = "id") Long id) {
		Optional<Empleado> cliente = empleIService.getById(id);
		if (cliente.isPresent()) {
			c.setId(id);
			empleIService.guardar(c);
		} else {
			throw new RuntimeException("El empleado no existe en la BD");
		}
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Empleado actualizado correctamente");
		return respuesta;
	}


}
