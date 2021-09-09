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

import com.acanuto.imobi.erp.dto.BancoDTO;
import com.acanuto.imobi.erp.model.Banco;
import com.acanuto.imobi.erp.service.BancoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Bancos")
@RestController
@RequestMapping("/api/bancos")
public class BancoController {
	
	@Autowired
	private BancoService service;
	
	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody BancoDTO bancoDTO) {
		try {
			return new ResponseEntity<Banco>(service.save(bancoDTO), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + System.lineSeparator() + e.getMessage());
		}
	}
	
	@GetMapping()
	@ApiOperation(value = "Este método é usado para consultar todos os bancos cadastrados.")
	@ResponseStatus(value = HttpStatus.OK)
	public List<Banco> getAll() {
		List<Banco> bancos = new ArrayList<>();
		service.getAll().forEach(bancos::add);
		return bancos;
	}

	@GetMapping("/{pix}")
	public ResponseEntity<?> getByPix(@RequestParam String pix) {
		Optional<Banco> banco = service.getByPix(pix);
		if (banco.isPresent()) {
			return new ResponseEntity<Optional<Banco>>(banco, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@RequestParam long id) {
		Optional<Banco> banco = service.getById(id);
		if (banco.isPresent()) {
			return new ResponseEntity<Optional<Banco>>(banco, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
