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

import com.acanuto.imobi.erp.dto.comprador.CompradorTrabalhoDTO;
import com.acanuto.imobi.erp.model.comprador.CompradorTrabalho;
import com.acanuto.imobi.erp.service.comprador.CompradorTrabalhoService;

@RestController
@RequestMapping("/api/comprador_trabalho")
public class CompradorTrabalhoController {

	@Autowired
	private CompradorTrabalhoService service;
	
	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody CompradorTrabalhoDTO trabalhoDTO) {
		try {
			return new ResponseEntity<CompradorTrabalho>(service.save(trabalhoDTO), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + System.lineSeparator() + e.getMessage());
		}
	}

	@GetMapping("/{compradorId}")
	public ResponseEntity<?> getByCompradorId(@RequestParam long compradorId) {
		Optional<CompradorTrabalho> trabalho = service.getByCompradorId(compradorId);
		if (trabalho.isPresent()) {
			return new ResponseEntity<Optional<CompradorTrabalho>>(trabalho, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@RequestParam long id) {
		Optional<CompradorTrabalho> trabalho = service.getById(id);
		if (trabalho.isPresent()) {
			return new ResponseEntity<Optional<CompradorTrabalho>>(trabalho, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
