package com.acanuto.imobi.erp.controller.comprador;

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

import com.acanuto.imobi.erp.dto.comprador.CompradorDTO;
import com.acanuto.imobi.erp.model.comprador.Comprador;
import com.acanuto.imobi.erp.service.comprador.CompradorService;

@RestController
@RequestMapping("/api/comprador")
public class CompradorController {

	@Autowired
	private CompradorService service;
	
	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody CompradorDTO compradorDTO) {
		try {
			return new ResponseEntity<Comprador>(service.save(compradorDTO), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + System.lineSeparator() + e.getMessage());
		}
	}
	
	@GetMapping()
	@ResponseStatus(value = HttpStatus.OK)
	public List<Comprador> getAll() {
		List<Comprador> compradors = new ArrayList<>();
		service.getAll().forEach(compradors::add);
		return compradors;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@RequestParam long id) {
		Optional<Comprador> comprador = service.getById(id);
		if (comprador.isPresent()) {
			return new ResponseEntity<Optional<Comprador>>(comprador, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{cpf}")
	public ResponseEntity<?> getByCpf(@RequestParam String cpf) {
		Optional<Comprador> comprador = service.getByCpf(cpf);
		if (comprador.isPresent()) {
			return new ResponseEntity<Optional<Comprador>>(comprador, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
