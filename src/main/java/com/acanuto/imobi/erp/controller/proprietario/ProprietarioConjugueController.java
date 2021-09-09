package com.acanuto.imobi.erp.controller.proprietario;

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
import org.springframework.web.bind.annotation.RestController;

import com.acanuto.imobi.erp.dto.proprietario.ProprietarioConjugueDTO;
import com.acanuto.imobi.erp.model.proprietario.ProprietarioConjugue;
import com.acanuto.imobi.erp.service.proprietario.ProprietarioConjugueService;

@CrossOrigin
@RestController
@RequestMapping("/api/proprietario_conjugue")
public class ProprietarioConjugueController {

	@Autowired
	private ProprietarioConjugueService service;
	
	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody ProprietarioConjugueDTO conjugueDTO) {
		try {
			return new ResponseEntity<ProprietarioConjugue>(service.save(conjugueDTO), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + System.lineSeparator() + e.getMessage());
		}
	}

	@GetMapping("/getByProprietarioId")
	public ResponseEntity<?> getByProprietarioId(@RequestParam long proprietarioId) {
		Optional<ProprietarioConjugue> conjugue = service.getByProprietarioId(proprietarioId);
		if (conjugue.isPresent()) {
			return new ResponseEntity<Optional<ProprietarioConjugue>>(conjugue, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping()
	public ResponseEntity<?> getById(@RequestParam long id) {
		Optional<ProprietarioConjugue> conjugue = service.getById(id);
		if (conjugue.isPresent()) {
			return new ResponseEntity<Optional<ProprietarioConjugue>>(conjugue, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
