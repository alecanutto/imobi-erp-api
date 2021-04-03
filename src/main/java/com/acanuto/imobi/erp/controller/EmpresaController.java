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

import com.acanuto.imobi.erp.dto.EmpresaDTO;
import com.acanuto.imobi.erp.model.Empresa;
import com.acanuto.imobi.erp.service.EmpresaService;

@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {

	@Autowired
	private EmpresaService service;

	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody EmpresaDTO empresaDTO) {
		try {
			service.save(empresaDTO);
			return new ResponseEntity<String>("Operação realizada com sucesso!", HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + System.lineSeparator() + e.getMessage());
		}
	}

	@GetMapping()
	@ResponseStatus(value = HttpStatus.OK)
	public List<Empresa> getAll() {
		List<Empresa> empresas = new ArrayList<>();
		service.getAll().forEach(empresas::add);
		return empresas;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@RequestParam long id) {
		Optional<Empresa> empresa = service.getById(id);
		if (empresa.isPresent()) {
			return new ResponseEntity<Optional<Empresa>>(empresa, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
