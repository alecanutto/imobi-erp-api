package com.acanuto.imobi.erp.controller.proprietario;

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
import org.springframework.web.bind.annotation.RestController;

import com.acanuto.imobi.erp.dto.proprietario.ProprietarioTrabalhoDTO;
import com.acanuto.imobi.erp.model.proprietario.ProprietarioTrabalho;
import com.acanuto.imobi.erp.service.proprietario.ProprietarioTrabalhoService;

@RestController
@RequestMapping("/api/proprietario_trabalho")
public class ProprietarioTrabalhoController {

	@Autowired
	private ProprietarioTrabalhoService service;
	
	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody ProprietarioTrabalhoDTO trabalhoDTO) {
		try {
			return new ResponseEntity<ProprietarioTrabalho>(service.save(trabalhoDTO), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + System.lineSeparator() + e.getMessage());
		}
	}

	@GetMapping("/{proprietarioId}")
	public ResponseEntity<?> getByProprietarioId(@RequestParam long proprietarioId) {
		Optional<ProprietarioTrabalho> trabalho = service.getByProprietarioId(proprietarioId);
		if (trabalho.isPresent()) {
			return new ResponseEntity<Optional<ProprietarioTrabalho>>(trabalho, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@RequestParam long id) {
		Optional<ProprietarioTrabalho> trabalho = service.getById(id);
		if (trabalho.isPresent()) {
			return new ResponseEntity<Optional<ProprietarioTrabalho>>(trabalho, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
