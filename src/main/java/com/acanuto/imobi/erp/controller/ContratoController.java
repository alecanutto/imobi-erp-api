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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.acanuto.imobi.erp.dto.ContratoDTO;
import com.acanuto.imobi.erp.model.Contrato;
import com.acanuto.imobi.erp.service.ContratoService;

@RestController
@RequestMapping("/api/contratos")
public class ContratoController {

	@Autowired
	private ContratoService service;

	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody ContratoDTO contratoDTO) {
		try {
			return new ResponseEntity<Contrato>(service.save(contratoDTO), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + System.lineSeparator() + e.getMessage());
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@RequestParam long id) {
		Optional<Contrato> contrato = service.getById(id);
		if (contrato.isPresent()) {
			return new ResponseEntity<Optional<Contrato>>(contrato, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{grupo}")
	@ResponseStatus(value = HttpStatus.OK)
	public List<Contrato> getAllByGrupo(@RequestParam String grupo) {
		return service.getAllByGrupo(grupo);
	}

	@GetMapping()
	@ResponseStatus(value = HttpStatus.OK)
	public List<Contrato> getAll() {
		List<Contrato> contratos = new ArrayList<>();
		service.getAll().forEach(contratos::add);
		return contratos;
	}

}
