package com.acanuto.imobi.erp.controller.proprietario;

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

import com.acanuto.imobi.erp.dto.proprietario.ProprietarioContaBancariaDTO;
import com.acanuto.imobi.erp.model.proprietario.ProprietarioContaBancaria;
import com.acanuto.imobi.erp.service.proprietario.ProprietarioContaBancariaService;

@RestController
@RequestMapping("/api/proprietario_bancos")
public class ProprietarioContaBancariaController {
	
	@Autowired
	private ProprietarioContaBancariaService service;
	
	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody ProprietarioContaBancariaDTO bancoDTO) {
		try {
			return new ResponseEntity<ProprietarioContaBancaria>(service.save(bancoDTO), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + System.lineSeparator() + e.getMessage());
		}
	}
	
	@GetMapping("/all/{proprietarioId}")
	@ResponseStatus(value = HttpStatus.OK)
	public List<ProprietarioContaBancaria> getAllByProprietarioId(long proprietarioId) {
		return service.getAllByProprietarioId(proprietarioId);
	}

	@GetMapping("/{proprietarioId}")
	public ResponseEntity<?> getByProprietarioId(@RequestParam long proprietarioId) {
		Optional<ProprietarioContaBancaria> banco = service.getByProprietarioId(proprietarioId);
		if (banco.isPresent()) {
			return new ResponseEntity<Optional<ProprietarioContaBancaria>>(banco, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@RequestParam long id) {
		Optional<ProprietarioContaBancaria> banco = service.getById(id);
		if (banco.isPresent()) {
			return new ResponseEntity<Optional<ProprietarioContaBancaria>>(banco, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
