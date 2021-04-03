package com.acanuto.imobi.erp.controller.comprador;

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

import com.acanuto.imobi.erp.dto.comprador.CompradorReferenciaDTO;
import com.acanuto.imobi.erp.model.comprador.CompradorReferencia;
import com.acanuto.imobi.erp.service.comprador.CompradorReferenciaService;

@RestController
@RequestMapping("/api/comprador_referencia")
public class CompradorReferenciaController {
		
	@Autowired
	private CompradorReferenciaService service;
	
	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody CompradorReferenciaDTO referenciaDTO) {
		try {
			return new ResponseEntity<CompradorReferencia>(service.save(referenciaDTO), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + System.lineSeparator() + e.getMessage());
		}
	}
	
	@GetMapping("/all/{compradorId}")
	@ResponseStatus(value = HttpStatus.OK)
	public List<CompradorReferencia> getAllByCompradorId(long compradorId) {
		return service.getAllByCompradorId(compradorId);
	}

	@GetMapping("/{compradorId}")
	public ResponseEntity<?> getByCompradorId(@RequestParam long compradorId) {
		Optional<CompradorReferencia> referencia = service.getByCompradorId(compradorId);
		if (referencia.isPresent()) {
			return new ResponseEntity<Optional<CompradorReferencia>>(referencia, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@RequestParam long id) {
		Optional<CompradorReferencia> referencia = service.getById(id);
		if (referencia.isPresent()) {
			return new ResponseEntity<Optional<CompradorReferencia>>(referencia, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
