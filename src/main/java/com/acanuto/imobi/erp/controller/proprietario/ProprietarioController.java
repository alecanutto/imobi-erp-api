package com.acanuto.imobi.erp.controller.proprietario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.acanuto.imobi.erp.dto.proprietario.ProprietarioDTO;
import com.acanuto.imobi.erp.model.proprietario.Proprietario;
import com.acanuto.imobi.erp.service.proprietario.ProprietarioService;

@CrossOrigin
@RestController
@RequestMapping("/api/proprietario")
public class ProprietarioController {

	@Autowired
	private ProprietarioService service;
	
	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody ProprietarioDTO proprietarioDTO) {
		try {
			return new ResponseEntity<Proprietario>(service.save(proprietarioDTO), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + System.lineSeparator() + e.getMessage());
		}
	}
	
	@GetMapping()
	@ResponseStatus(value = HttpStatus.OK)
	public List<Proprietario> getAll() {
		List<Proprietario> proprietarios = new ArrayList<>();
		service.getAll().forEach(proprietarios::add);
		return proprietarios;
	}

	@GetMapping("/id")
	public ResponseEntity<?> getById(@RequestParam long id) {
		Optional<Proprietario> proprietario = service.getById(id);
		if (proprietario.isPresent()) {
			return new ResponseEntity<Optional<Proprietario>>(proprietario, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/cpf")
	public ResponseEntity<?> getByCpf(@RequestParam String cpf) {
		Optional<Proprietario> proprietario = service.getByCpf(cpf);
		if (proprietario.isPresent()) {
			return new ResponseEntity<Optional<Proprietario>>(proprietario, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
