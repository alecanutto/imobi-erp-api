package com.acanuto.imobi.erp.controller.comprador;

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

import com.acanuto.imobi.erp.dto.comprador.CompradorConjugueDTO;
import com.acanuto.imobi.erp.model.comprador.CompradorConjugue;
import com.acanuto.imobi.erp.service.comprador.CompradorConjugueService;

@RestController
@RequestMapping("/api/comprador_conjugue")
public class CompradorConjugueController {

	@Autowired
	private CompradorConjugueService service;
	
	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody CompradorConjugueDTO conjugueDTO) {
		try {
			return new ResponseEntity<CompradorConjugue>(service.save(conjugueDTO), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + System.lineSeparator() + e.getMessage());
		}
	}

	@GetMapping("/{compradorId}")
	public ResponseEntity<?> getByCompradorId(@RequestParam long compradorId) {
		Optional<CompradorConjugue> conjugue = service.getByCompradorId(compradorId);
		if (conjugue.isPresent()) {
			return new ResponseEntity<Optional<CompradorConjugue>>(conjugue, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@RequestParam long id) {
		Optional<CompradorConjugue> conjugue = service.getById(id);
		if (conjugue.isPresent()) {
			return new ResponseEntity<Optional<CompradorConjugue>>(conjugue, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
