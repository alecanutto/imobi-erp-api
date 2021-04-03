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

import com.acanuto.imobi.erp.dto.fiador.FiadorTrabalhoDTO;
import com.acanuto.imobi.erp.model.fiador.FiadorTrabalho;
import com.acanuto.imobi.erp.service.fiador.FiadorTrabalhoService;

@RestController
@RequestMapping("/api/fiador_trabalho")
public class FiadorTrabalhoController {

	@Autowired
	private FiadorTrabalhoService service;
	
	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody FiadorTrabalhoDTO trabalhoDTO) {
		try {
			return new ResponseEntity<FiadorTrabalho>(service.save(trabalhoDTO), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + System.lineSeparator() + e.getMessage());
		}
	}

	@GetMapping("/{fiadorId}")
	public ResponseEntity<?> getByFiadorId(@RequestParam long fiadorId) {
		Optional<FiadorTrabalho> trabalho = service.getByFiadorId(fiadorId);
		if (trabalho.isPresent()) {
			return new ResponseEntity<Optional<FiadorTrabalho>>(trabalho, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@RequestParam long id) {
		Optional<FiadorTrabalho> trabalho = service.getById(id);
		if (trabalho.isPresent()) {
			return new ResponseEntity<Optional<FiadorTrabalho>>(trabalho, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
