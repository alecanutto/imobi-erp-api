package com.acanuto.imobi.erp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.acanuto.imobi.erp.dto.FuncionarioDTO;
import com.acanuto.imobi.erp.model.Funcionario;
import com.acanuto.imobi.erp.service.FuncionarioService;

@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioService service;
	
	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody FuncionarioDTO funcionarioDTO) {
		try {
			return new ResponseEntity<Funcionario>(service.save(funcionarioDTO), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + System.lineSeparator() + e.getMessage());
		}
	}
	
	@PutMapping()
	public ResponseEntity<?> update(@Valid @RequestBody FuncionarioDTO funcionarioDTO) {
		try {
			return new ResponseEntity<Funcionario>(service.update(funcionarioDTO), HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + System.lineSeparator() + e.getMessage());
		}
	}

	@GetMapping()
	@ResponseStatus(value = HttpStatus.OK)
	public List<Funcionario> getAll() {
		List<Funcionario> funcionarios = new ArrayList<>();
		service.getAll().forEach(funcionarios::add);
		return funcionarios;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@RequestParam long id) {
		Optional<Funcionario> emp = service.getById(id);
		if (emp.isPresent()) {
			return new ResponseEntity<Optional<Funcionario>>(emp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{cpf}")
	public ResponseEntity<?> getByCpf(@RequestParam String cpf) {
		Optional<Funcionario> emp = service.getByCpf(cpf);
		if (emp.isPresent()) {
			return new ResponseEntity<Optional<Funcionario>>(emp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{username}")
	public ResponseEntity<?> getByUsername(@RequestParam String username) {
		Optional<Funcionario> emp = service.getByUsername(username);
		if (emp.isPresent()) {
			return new ResponseEntity<Optional<Funcionario>>(emp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
