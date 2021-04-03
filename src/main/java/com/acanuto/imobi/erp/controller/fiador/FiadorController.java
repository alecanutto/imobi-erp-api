package com.acanuto.imobi.erp.controller.fiador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.acanuto.imobi.erp.dto.fiador.FiadorDTO;
import com.acanuto.imobi.erp.model.fiador.Fiador;
import com.acanuto.imobi.erp.service.fiador.FiadorService;

@RestController
@RequestMapping("/api/fiador")
public class FiadorController {

	@Autowired
	private FiadorService service;
	
	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody FiadorDTO fiadorDTO) {
		try {
			return new ResponseEntity<Fiador>(service.save(fiadorDTO), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + System.lineSeparator() + e.getMessage());
		}
	}
	
	@GetMapping()
	@ResponseStatus(value = HttpStatus.OK)
	public List<Fiador> getAll() {
		List<Fiador> fiadors = new ArrayList<>();
		service.getAll().forEach(fiadors::add);
		return fiadors;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@RequestParam long id) {
		Optional<Fiador> fiador = service.getById(id);
		if (fiador.isPresent()) {
			return new ResponseEntity<Optional<Fiador>>(fiador, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{cpf}")
	public ResponseEntity<?> getByCpf(@RequestParam String cpf) {
		Optional<Fiador> fiador = service.getByCpf(cpf);
		if (fiador.isPresent()) {
			return new ResponseEntity<Optional<Fiador>>(fiador, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
