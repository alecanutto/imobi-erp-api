package com.acanuto.imobi.erp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.acanuto.imobi.erp.dto.CaracteristicasDTO;
import com.acanuto.imobi.erp.model.Caracteristicas;
import com.acanuto.imobi.erp.service.CaracteristicasService;

@RestController
@RequestMapping("/api/caracteristicas")
public class CaracteristicasController {

	@Autowired
	private CaracteristicasService service;

	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody CaracteristicasDTO dto) {
		try {
			return new ResponseEntity<Caracteristicas>(service.save(dto), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + System.lineSeparator() + e.getMessage());
		}
	}

	@GetMapping()
	@ResponseStatus(value = HttpStatus.OK)
	public List<Caracteristicas> getAll() {
		return service.getAll();
	}

	@GetMapping("/{categoria}")
	public List<Caracteristicas> getAllByCategoria(@RequestParam String categoria) {
		return service.getAllByCategoria(categoria);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@RequestParam long id) {
		Optional<Caracteristicas> dto = service.getById(id);
		if (dto.isPresent()) {
			return new ResponseEntity<Optional<Caracteristicas>>(dto, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public void deleById(@RequestParam long id) {
		service.deleteById(id);
	}

}
