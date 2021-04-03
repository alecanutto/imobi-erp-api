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

import com.acanuto.imobi.erp.dto.proprietario.ProprietarioReferenciaDTO;
import com.acanuto.imobi.erp.model.proprietario.ProprietarioReferencia;
import com.acanuto.imobi.erp.service.proprietario.ProprietarioReferenciaService;

@RestController
@RequestMapping("/api/proprietario_referencia")
public class ProprietarioReferenciaController {
		
	@Autowired
	private ProprietarioReferenciaService service;
	
	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody ProprietarioReferenciaDTO referenciaDTO) {
		try {
			return new ResponseEntity<ProprietarioReferencia>(service.save(referenciaDTO), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + System.lineSeparator() + e.getMessage());
		}
	}
	
	@GetMapping("/all/{proprietarioId}")
	@ResponseStatus(value = HttpStatus.OK)
	public List<ProprietarioReferencia> getAllByProprietarioId(long proprietarioId) {
		return service.getAllByProprietarioId(proprietarioId);
	}

	@GetMapping("/{proprietarioId}")
	public ResponseEntity<?> getByProprietarioId(@RequestParam long proprietarioId) {
		Optional<ProprietarioReferencia> referencia = service.getByProprietarioId(proprietarioId);
		if (referencia.isPresent()) {
			return new ResponseEntity<Optional<ProprietarioReferencia>>(referencia, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@RequestParam long id) {
		Optional<ProprietarioReferencia> referencia = service.getById(id);
		if (referencia.isPresent()) {
			return new ResponseEntity<Optional<ProprietarioReferencia>>(referencia, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
