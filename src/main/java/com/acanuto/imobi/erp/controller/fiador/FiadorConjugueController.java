package com.acanuto.imobi.erp.controller.fiador;

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

import com.acanuto.imobi.erp.dto.fiador.FiadorConjugueDTO;
import com.acanuto.imobi.erp.model.fiador.FiadorConjugue;
import com.acanuto.imobi.erp.service.fiador.FiadorConjugueService;

@RestController
@RequestMapping("/api/fiador_conjugue")
public class FiadorConjugueController {

	@Autowired
	private FiadorConjugueService service;
	
	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody FiadorConjugueDTO conjugueDTO) {
		try {
			return new ResponseEntity<FiadorConjugue>(service.save(conjugueDTO), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + System.lineSeparator() + e.getMessage());
		}
	}

	@GetMapping("/{fiadorId}")
	public ResponseEntity<?> getByFiadorId(@RequestParam long fiadorId) {
		Optional<FiadorConjugue> conjugue = service.getByFiadorId(fiadorId);
		if (conjugue.isPresent()) {
			return new ResponseEntity<Optional<FiadorConjugue>>(conjugue, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@RequestParam long id) {
		Optional<FiadorConjugue> conjugue = service.getById(id);
		if (conjugue.isPresent()) {
			return new ResponseEntity<Optional<FiadorConjugue>>(conjugue, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
